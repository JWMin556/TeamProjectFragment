package com.example.teamprojectfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teamprojectfragment.databinding.ListUsersBinding
                    //어떤 모델을 사용할지를 넘겨받습니다. MyUser에 있는 array를 넘겨받습니다.
class UserAdapter(val context: Context, private val userList: ArrayList<MyUser>)
    : RecyclerView.Adapter<UserAdapter.Holder>() {  //리사이클러뷰의 한칸을 보여주는 adapter입니다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ListUsersBinding.inflate(LayoutInflater.from(parent.context))
        val holder = Holder(binding)
        return holder
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {  //randering을 될 수 있도록 역할을 합니다.
        holder.bind(userList[position])
    }

    override fun getItemCount() = userList.size  //이 안의 회원숫자를 보여줍니다.

    class Holder(private val binding: ListUsersBinding) : RecyclerView.ViewHolder(binding.root){  //한칸을 어떻게 묘사할지에 대한 코드입니다.
        fun bind(user : MyUser){
            binding.txtRanking.text = "${position + 1}등"
            binding.txtEmail.text = user.email
            binding.txtPoint.text = "${user.myPoint}p"
        }
    }
    }