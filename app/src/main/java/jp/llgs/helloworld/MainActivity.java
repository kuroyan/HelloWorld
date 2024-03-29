package jp.llgs.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String toastMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btClick = findViewById(R.id.btClick);
        HelloworldListner listner = new HelloworldListner();
        btClick.setOnClickListener(listner);

        Button button = findViewById(R.id.button);

        toastMessage ="勤務表提出日です！";

        toastMake(toastMessage, 0, -200);

        //EditText input = findViewById(R.id.eｔName);
        //toastMessage = input.getText().toString();
        // 画像を使ったトーストをやりたい
        // ここがコミット＆pushできていないが

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMake(toastMessage, 0, 10);
            }
        });

        Button btClear = findViewById(R.id.btclear);
        btClear.setOnClickListener(listner);
    }

    private void toastMake(String message, int x, int y){
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        // 位置調整
        toast.setGravity(Gravity.CENTER, x, y);
        toast.show();
    }

    private class HelloworldListner implements View.OnClickListener{
        @Override
        public void onClick(View view){
            EditText input = findViewById(R.id.eｔName);
            TextView output= findViewById(R.id.tvOutput);

            ImageView imgV = findViewById(R.id.imageView);
            imgV.setAlpha(0.9f);

            //ImageView imgV =  (ImageView)findViewById(R.id.imageView);
            //imgV.setAlpha(0.5f);

            int id = view.getId();

            switch(id){
                case R.id.btClick:
                    String inputStr = input.getText().toString();
                    output.setText(inputStr + "さん、こんにちは！");
                    break;
                case R.id.btclear:
                    imgV.setAlpha(0.2f);
                    input.setText("");
                    output.setText("");
                    break;
            }
        }

    }
}
