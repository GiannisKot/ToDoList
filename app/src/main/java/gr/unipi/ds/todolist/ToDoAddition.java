package gr.unipi.ds.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ToDoAddition extends AppCompatActivity {
    public FirebaseDatabase mFirebaseDatabase;
    public DatabaseReference mMessagesDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do_add_layout);
    }

    public void addButtonClicked(View v){
        String message = ((EditText)findViewById(R.id.msg)).getText().toString();
        if (message.equals("")){

        } else {
            Intent intent = new Intent();
            setResult(IntentReq.intent_result_code,intent);
            mFirebaseDatabase = FirebaseDatabase.getInstance();
            mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("messages");
            mMessagesDatabaseReference.push().setValue(message);

            finish();
        }
    }
}
