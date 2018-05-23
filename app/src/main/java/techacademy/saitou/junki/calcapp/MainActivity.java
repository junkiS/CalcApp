package techacademy.saitou.junki.calcapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //メンバ関数定義
    EditText mEditText;
    EditText EditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        // findViewByIdを使ってインスタンスを代入
        mEditText = (EditText) findViewById(R.id.editText);
        EditText2 = (EditText) findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {

        TextView mTextView;
        mTextView = (TextView) findViewById(R.id.textView);

        String val = mEditText.getText().toString();
        double db; //double db 宣言

        String val2 = EditText2.getText().toString();
        double db2;

        double result = 0;

        try {

            db = Double.parseDouble(val); //String型からDouble型に変換
            db2 = Double.parseDouble(val2);

        } catch (NumberFormatException e) {
            Log.d("Text", "なにも入力されていません。");
            return;
        }
        try {
            if (db2 == 0) {
                throw new ArithmeticException("0で割ったときの例外を発生させる");
            }
            result = db / db2;

        }catch (Exception e){
            System.out.println("例外が発生しました。");
            System.out.println(e);
            mTextView.setText("0除算は出来ません");
            return;
        }


        if (v.getId() == R.id.button1) {
            result = db + db2; // +
        } else if (v.getId() == R.id.button2) {
            result = db - db2; // -
        } else if (v.getId() == R.id.button3) {
            result = db * db2; // *
        } else if (v.getId() == R.id.button4) {
            result = db / db2; // /
        }
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("EditText", result);
        startActivity(intent);
    }
}
