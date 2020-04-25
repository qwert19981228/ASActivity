package com.example.activitytest

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.first_layout.*

class FirstActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FirstActivity","Task id is $taskId")
        setContentView(R.layout.first_layout)
        // 为按钮添加点击事件
        button1.setOnClickListener {
            // 添加一个Toast(提醒)
//            Toast.makeText(this,"You clicked Button 1", Toast.LENGTH_SHORT).show()
            // 销毁一个Activity
//            finish()
//            val intent = Intent(this,SecondActivity::class.java)
//            val intent = Intent("com.example.activitytest.ACTION_START")
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.addCategory("com.example.activitytest.MY_CATEGORY")
//            intent.data = Uri.parse("https://www.baidu.com")
//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:10086")
//            val data = "Hello SecondActivity"
//            val intent = Intent(this,SecondActivity::class.java)
//            intent.putExtra("extra_data","data")
//            startActivity(intent)
//            val intent = Intent(this,SecondActivity::class.java)
//            startActivityForResult(intent,1)
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
    }
    // 添加菜单
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return true
    }
    // 为菜单添加点击事件
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.add_item -> Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){
            1 -> if (resultCode == RESULT_OK){
                val returnedData = data?.getStringExtra("data_return")
                Log.d("FirstActivity","returned data is $returnedData")
            }

        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("FirstActivity","onRestart")
    }

}

