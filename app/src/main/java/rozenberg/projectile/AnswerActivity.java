package rozenberg.projectile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Elise on 10/15/2015.
 */
public class AnswerActivity extends AppCompatActivity {
    //every activity will end with activity  (like a test class)
    //they all extend app copact

    private TextView answer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        answer = (TextView)findViewById(R.id.answer);

        //get the intent and set default values
        Intent intent = getIntent();
        double angle = intent.getDoubleExtra("Angle", 0.0);
        double velocity = intent.getDoubleExtra("Velocity", 0.0);
        double time = intent.getDoubleExtra("Time", 0.0);

        Projectile projectile = new Projectile(angle,velocity,time);
        answer.setText("x = " +  projectile.getX() + "    y= " + projectile.getY() );



    }

}
