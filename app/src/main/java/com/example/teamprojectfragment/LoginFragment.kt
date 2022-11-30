package com.example.teamprojectfragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.teamprojectfragment.databinding.FragmentLoginBinding
import com.google.firebase.storage.FirebaseStorage
import java.util.*


class LoginFragment : Fragment() {

    val storage = FirebaseStorage.getInstance() //스토리지 인스턴스 생성
    val storageRef = storage.getReference() //스토리지 참조

    var binding: FragmentLoginBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnUpload?.setOnClickListener {
            val galleryIntent = Intent(Intent.ACTION_PICK) //앨범 호출
            galleryIntent.type = "image/*" //image type
            resultImage.launch(galleryIntent) //ActivityResultContract 실행
        }
    }

    //registerForActivityResult ARC 가져와서 ARL 반환
    //ARC 결과에 필요한 입출력 유형 정의
    var resultImage: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result->
            if(result != null){
                //선택된 이미지의 URI 가져오기
                val imageUri: Uri? = result.data?.data
                //고유한 객체의 식별하기 위한 UUID를 파일명으로 사용
                val fileName = UUID.randomUUID().toString()
                //하위 file에 fileName을 갖는 파일을 업로드
                if (imageUri != null) {
                    storageRef.child("file/$fileName").putFile(imageUri)
                }

            }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}