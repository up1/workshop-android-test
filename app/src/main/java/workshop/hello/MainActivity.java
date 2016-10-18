package workshop.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultTV;
    private EditText num1ET;
    private EditText num2ET;
    private Button minusBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTV = (TextView) findViewById(R.id.result);
        num1ET = (EditText) findViewById(R.id.num1);
        num2ET = (EditText) findViewById(R.id.num2);
        minusBtn = (Button) findViewById(R.id.minusBtn);
    }

    public void onCalculate(View view) {
        Calculator calculator = new Calculator();
        int number1 = Integer.parseInt(num1ET.getText().toString());
        int number2 = Integer.parseInt(num2ET.getText().toString());
        double result = 0.0;
        if(Operation.Minus == getCurrentOperation()) {
            result = calculator.minus(number1, number2);
        } else {
            result = calculator.add(number1, number2);
        }
        resultTV.setText(String.valueOf(result));
    }

    private Operation currentOperation = Operation.ADD;

    private Operation getCurrentOperation() {
        return this.currentOperation;
    }

    public void onMinus(View view) {
        this.currentOperation = Operation.Minus;
    }

    public void onAdd(View view) {
        this.currentOperation = Operation.ADD;
    }
}

enum Operation {
    ADD, Minus
}
