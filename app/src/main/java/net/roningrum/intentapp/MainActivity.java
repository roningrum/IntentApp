package net.roningrum.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        Button btnMoveActivityData = findViewById(R.id.btn_move_activity_data);
        btnMoveActivityData.setOnClickListener(this);

        Button btnDialPhone = findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_move_activity_data:
                //putExtra() merupakan metode untuk menampung pasangan key value. Semua input value didukung oleh metode ini
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                /***EXTRA_NAME dan EXTRA_AGE diambil dari variabel di kelas MoveWithDataActivity
                 * kemudian masing masing dimasukkan key berupa nilai yang akan ditampilkan**/
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "dicoding");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 16);
                startActivity(moveWithDataIntent);
                break;
            case R.id.btn_dial_number:
                String phoneNumber ="08232676061";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;

        }

    }
}
