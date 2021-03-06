package rozenberg.projectile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    private TextView textAns;

    private EditText editTextVelocity;
    private EditText editTextAngle;
    private EditText editTextTime;

    private Button buttonCalc;

    private double angle, velocity, time;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //name - mode - restrcition that they have with the rest of the application
        preferences = this.getSharedPreferences("DEFAULT", MODE_PRIVATE);
        imageView = (ImageView) findViewById(R.id.image2);
        Picasso.with(this)
                .load("http://jokideo.com/wp-content/uploads/2013/03/226431_518712648181745_1707739609_n.jpg")
                .error(R.drawable.error_image)
                .into(imageView);


        editTextAngle = (EditText) findViewById(R.id.editText1);
        editTextVelocity = (EditText) findViewById(R.id.editText2);
        editTextTime = (EditText) findViewById(R.id.editText3);
        buttonCalc = (Button) findViewById(R.id.button1);
        textAns = (TextView) findViewById(R.id.textAns);
        //assuming have the image thing paste the line of code
        //replace context - with this

        buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateProjectile();
            }
        });
    }

    private void calculateProjectile() {
        angle = Double.parseDouble(editTextAngle.getText().toString());
        velocity = Double.parseDouble(editTextVelocity.getText().toString());
        time = Double.parseDouble(editTextTime.getText().toString());
        //Projectile projectile = new Projectile(angle,velocity,time);
        //textAns.setText("x = " +  projectile.getX() + "  y= " + projectile.getY() );

        Intent intent = new Intent(this, AnswerActivity.class);
        //send the data to intent
        intent.putExtra("Angle", angle);
        intent.putExtra("Velocity", velocity);
        intent.putExtra("Time", time);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = preferences.edit();
        //like a hashmap - there is a key and a value
        editor.putString("ANGLE", editTextAngle.getText().toString());
        editor.putString("VELOCITY", editTextVelocity.getText().toString());
        editor.putString("TIME", editTextTime.getText().toString());
        editor.apply();
    }

    @Override
    public void onResume() {
        super.onResume();
        editTextAngle.setText(preferences.getString("ANGLE", ""));
        editTextVelocity.setText(preferences.getString("VELOCITY",""));
        editTextTime.setText(preferences.getString("TIME",""));
    }

}
