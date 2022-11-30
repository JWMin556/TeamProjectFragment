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
import com.example.teamprojectfragment.databinding.FragmentEntryBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.storage.FirebaseStorage
import java.util.*


class EntryFragment : Fragment() {

    val storage = FirebaseStorage.getInstance() //스토리지 인스턴스 생성
    val storageRef = storage.getReference() //스토리지 참조

    lateinit var auth: FirebaseAuth
    lateinit var mDbRef: DatabaseReference
    var binding: FragmentEntryBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEntryBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        mDbRef = Firebase.database.reference

        binding?.btnUpload?.setOnClickListener { //사진업로드용 버튼입니다.
            val galleryIntent = Intent(Intent.ACTION_PICK) //앨범 호출
            galleryIntent.type = "image/*" //image type
            resultImage.launch(galleryIntent) //ActivityResultContract 실행
        }

        binding?.btnSignUp?.setOnClickListener {  //회원가입용 버튼입니다.
            val myPoint = 0
            val email = binding?.edtEmail?.text.toString()
            val password = binding?.edtPwd?.text.toString()
            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(getActivity(),"회원가입에 성공했습니다!",Toast.LENGTH_SHORT).show()
                        addUserToDatabase(email, myPoint, auth.currentUser?.uid!!)
                    }else{
                        Toast.makeText(getActivity(),"이미 존재하는 계정이거나, 회원가입에 실패했습니다.",Toast.LENGTH_SHORT).show()
                    }
                }
        }

        binding?.btnLogIn?.setOnClickListener{     //로그인용 버튼입니다
            val email = binding?.edtEmail?.text.toString()
            val password = binding?.edtPwd?.text.toString()
            auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        Toast.makeText(getActivity(),"로그인에 성공했습니다!",Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_entryFragment_to_startFragment)
                    }else {
                        Toast.makeText(getActivity(),"아이디와 비밀번호를 확인해주세요.",Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun addUserToDatabase(email: String, myPoint: Int, uId: String){
        mDbRef.child("myUser").child(uId).setValue(MyUser(email, myPoint, uId))
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