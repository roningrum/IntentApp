package net.roningrum.intentappkotlinversion

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_phone)
        btnDialPhone.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_move_activity ->{
               val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_data->{
                val moveWithDataActivity = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataActivity.putExtra(MoveWithDataActivity.EXTRA_NAME, "dicoding")
                moveWithDataActivity.putExtra(MoveWithDataActivity.EXTRA_AGE, 16)
                startActivity(moveWithDataActivity)
            }
            R.id.btn_dial_phone->{
                //Action_Dial digunakan untuk intent filter dari aplikasi yang bisa menangani action
                //contoh panggilan
                // /*Uri = Uninform Resource Intent
                // fungsi Uri = mengidentifikasikan nama, sumber atau layanan internet
                // **/
                val phoneNumber = "082327676061"
                val dialPhone = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhone)
            }

        }
    }
}
