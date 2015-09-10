package non.renge.nyanpass;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;


/**
 */
public class OutlineTextView extends TextView {

    public OutlineTextView(Context context) {
        super(context);
    }

    public OutlineTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OutlineTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    //draw the text many times so that the shadow becomes a solid outline
    @Override
    public void draw(Canvas canvas){
        for(int i=0;i<20;i++){
            super.draw(canvas);
        }
    }
}
