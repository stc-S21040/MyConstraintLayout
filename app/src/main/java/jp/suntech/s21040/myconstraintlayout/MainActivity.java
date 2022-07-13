package jp.suntech.s21040.myconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btSend = findViewById(R.id.btSend);
        Button btClear = findViewById(R.id.btClear);
        ItemListener listener = new ItemListener();
        btSend.setOnClickListener(listener);
        btClear.setOnClickListener(listener);

    }

    private class ItemListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText input1 = findViewById(R.id.etName);
            EditText input2 = findViewById(R.id.etNameTitle);
            EditText input3 = findViewById(R.id.etMail);
            EditText input4 = findViewById(R.id.etComment);

            int id = view.getId();
            switch (id) {
                case R.id.btSend:
                    String inputStr1 = input1.getText().toString();
                    String inputStr2 = input2.getText().toString();
                    String inputStr3 = input3.getText().toString();
                    String inputStr4 = input4.getText().toString();
                    String show = "以下を送信しました：\n" +
                            "名前：" + inputStr1 +
                            "\nメールタイトル：" + inputStr2 +
                            "\nメールアドレス：" + inputStr3 +
                            "\n質問：" + inputStr4;
                    Toast.makeText(MainActivity.this, show, Toast.LENGTH_LONG).show();
                    break;
                case R.id.btClear:
                    input1.setText("");
                    input2.setText("");
                    input3.setText("");
                    input4.setText("");
                    break;
            }
        }
    }
}