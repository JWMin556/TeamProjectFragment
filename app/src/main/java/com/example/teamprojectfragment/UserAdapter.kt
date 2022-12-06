package com.example.teamprojectfragment
<<<<<<< HEAD
// 랭킹 페이지에서 유저 한 칸을 나타냄

=======
//랭킹 페이지에서 유저 한 칸을 나타냄
>>>>>>> 2ae06a7c768fc5ebe16ba957fddf40f23ffb1ab4
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teamprojectfragment.databinding.ListUsersBinding

class UserAdapter(val context: Context, private val userList: ArrayList<MyUser>)
    : RecyclerView.Adapter<UserAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ListUsersBinding.inflate(LayoutInflater.from(parent.context))
        val holder = Holder(binding)
        return holder
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount() = userList.size

    class Holder(private val binding: ListUsersBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(user : MyUser){
            binding.txtRanking.text = "${position + 1}등"
            binding.txtEmail.text = user.email
            binding.txtPoint.text = "${user.myPoint}p"
        }
    }
    }