package ir.adicom.app.talacalculator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by adicom on 8/18/16.
 */
public class CustomButton extends LinearLayout {
    TextView textView;
    Button btnInc, btnDec;
    int number;

    public CustomButton(Context context) {
        super(context);
        init();
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        View view = inflate(getContext(), R.layout.custom_button, null);
        textView = (TextView) view.findViewById(R.id.textView2);
        btnInc = (Button) view.findViewById(R.id.btnInc);
        btnInc.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number<100)
                    number++;
                textView.setText("" + number);
            }
        });

        btnDec = (Button) view.findViewById(R.id.btnDec);
        btnDec.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number>0)
                    number--;
                textView.setText("" + number);
            }
        });
        addView(view);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int n) {
        this.number = n;
        textView.setText("" + number);
    }
}
