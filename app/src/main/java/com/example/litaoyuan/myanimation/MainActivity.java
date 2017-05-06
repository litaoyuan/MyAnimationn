package com.example.litaoyuan.myanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.tran)
    TextView tran;
    @BindView(R.id.scale)
    TextView scale;
    @BindView(R.id.rotate)
    TextView rotate;
    @BindView(R.id.alpha)
    TextView alpha;
    @BindView(R.id.tween)
    TextView tween1;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    @BindView(R.id.img_list)
    ImageView imgList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //第二次上传


    }

    @OnClick({R.id.tran, R.id.scale, R.id.rotate, R.id.alpha,R.id.tween})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            /**            animationSet.setFillBefore(true);//动画执行完成后，控件将回到在执行之前的状态位置
             @android:anim/accelerate_interpolator： 越来越快

             @android:anim/decelerate_interpolator：越来越慢

             @android:anim/accelerate_decelerate_interpolator：先快后慢

             @android:anim/anticipate_interpolator: 先后退一小步然后向前加速

             @android:anim/overshoot_interpolator：快速到达终点超出一小步然后回到终点

             @android:anim/anticipate_overshoot_interpolator：到达终点超出一小步然后回到终点

             @android:anim/bounce_interpolator：到达终点产生弹球效果，弹几下回到终点

             @android:anim/linear_interpolator：均匀速度。*/
            case R.id.tran:
//                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.in_from_down);
//                img.startAnimation(animation);
//                AnimationSet animationSet = new AnimationSet(true);//创建一个AnimationSet对象，参数为boolean型。true表示使用AnimationSet的interpolator,false表示使用自己的。  注释：适合多种动画一起用，AnimationSet就是一个集合。
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 300, 0, 300);//1:表示X轴的开始位置。2:表示X轴的结束位置。3:表示轴的开始位置。4:表示Y轴的结束位置
                translateAnimation.setDuration(3000);//动画执行时间
                translateAnimation.setRepeatCount(3);//设置动画重复执行的次数
                translateAnimation.setRepeatMode(Animation.REVERSE);////设置重复模式，RESTART为结束后重新开始，REVERSE为按原来的轨迹逆向返回
                translateAnimation.setInterpolator(new BounceInterpolator());
                translateAnimation.setFillAfter(true);//动画执行完成后，控件将停留在执行结束的状态位置
                translateAnimation.setStartOffset(300);//设置动画执行之前的等待时间
//                translateAnimation.addAnimation(translateAnimation);//animationSet添加动画
                img.startAnimation(translateAnimation);//开始动画
                break;
            case R.id.scale:
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_animation);
                img.startAnimation(animation);

//                参数解释：
                /**  第一个参数：X轴水平缩放起始位置的大小（fromX）。1代表正常大小
                 第二个参数：X轴水平缩放完了之后（toX）的大小，0代表完全消失了
                 第三个参数：Y轴垂直缩放起始时的大小（fromY）
                 第四个参数：Y轴垂直缩放结束后的大小（toY） */


//                第一个参数fromX ,
//                第二个参数toX:分别是动画起始、结束时X坐标上的伸缩尺寸。
//                第三个参数fromY ,
//                第四个参数toY:分别是动画起始、结束时Y坐标上的伸缩尺寸。
//                另外还可以设置伸缩模式pivotXType、pivotYType， 伸缩动画相对于x,y 坐标的开始位置pivotXValue、pivotYValue等。
//                第五个参数：pivotXType为动画在X轴相对于物件位置类型
//                第六个参数：pivotXValue为动画相对于物件的X坐标的开始位置
//                第七个参数：pivotXType为动画在Y轴相对于物件位置类型
//                第八个参数：pivotYValue为动画相对于物件的Y坐标的开始位置
                ScaleAnimation scaleAnimation = new ScaleAnimation(1, 2, 1, 2);
                //3秒完成动画
                scaleAnimation.setDuration(2000);
                scaleAnimation.setFillAfter(true);//动画执行完成后，控件将停留在执行结束的状态位置
//                //将AlphaAnimation这个已经设置好的动画添加到 AnimationSet中
//                animationSet.addAnimation(scaleAnimation);
                //启动动画
                img.startAnimation(scaleAnimation);
                break;
            case R.id.rotate:
//                Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate_animation);
//                img.startAnimation(animation1);
                RotateAnimation rotate = new RotateAnimation(0f, 360f, 200, 200);
                rotate.setInterpolator(new LinearInterpolator());
                rotate.setDuration(1500);//设置动画持续时间
                rotate.setRepeatCount(2);//设置重复次数
                rotate.setFillAfter(true);//动画执行完后是否停留在执行完的状态
//                rotate.setStartOffset(10);//执行前的等待时间
                img.setAnimation(rotate);
                break;
            case R.id.alpha:
                AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
                alphaAnimation.setDuration(1500);//设置动画持续时间
                alphaAnimation.setFillAfter(true);//动画执行完后是否停留在执行完的状态
                img.setAnimation(alphaAnimation);


//                Drawable[] drawableArray = {
//                        getResources().getDrawable(R.drawable.alpha_begin),
//                        getResources().getDrawable(R.drawable.alpha_end)
//                };
//                transitionDrawable = new TransitionDrawable(drawableArray);
//                img.setImageDrawable(transitionDrawable);
                //淡入淡出动画需要先设置一个Drawable数组，用于变换图片
                break;
            case R.id.tween:
                img.setVisibility(View.GONE);
                AnimationDrawable animationDrawable = (AnimationDrawable) imgList.getDrawable();
                animationDrawable.setOneShot(false);// false为循环播放，true为仅播放一次
                animationDrawable.start();
                break;
        }
    }


}
