package com.blackcoffee.work.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.entity.SelfContact;
import com.blackcoffee.work.presenter.PresenterQRCodeIdentifyCard;
import com.blackcoffee.work.test.TestContent;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.iview.IQRCodeIdentifyCardView;
import com.blackcoffee.work.ui.widget.DrawableInText;
import com.blackcoffee.work.ui.widget.cirlceimageview.CircleImageView;
import com.blackcoffee.work.universal.function.FunctionText;
import com.blackcoffee.work.universal.img.ImgUtil;
import com.blackcoffee.work.util.ToastUtil;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.BarcodeFormat;

import java.util.Hashtable;


/**
 * 二维码名片的Activity
 */
public class QRCodeIdentifyCardActivity extends BaseActivity<IQRCodeIdentifyCardView, PresenterQRCodeIdentifyCard> implements
        IQRCodeIdentifyCardView,
        View.OnClickListener {


    private PresenterQRCodeIdentifyCard presenterQRCodeIdentifyCard;


    /**
     * titlle
     */
    private ImageView iv_common_back;
    private TextView tv_common_title;


    private TextView tv_name;
    private CircleImageView civ_user_head;
    private ImageView iv_qr_identify_card;


    /**
     * 数据相关
     */

    private int QR_WIDTH = 400;
    private int QR_HEIGHT = 400;
    private SelfContact selfContact;

    /**
     * 生成二维码
     *
     * @param url
     */

    public Bitmap createQRImage(String url) {


        Bitmap bitmap = null;


        try {
            //判断URL合法性
            if (url == null || "".equals(url) || url.length() < 1) {
                return bitmap;
            }
            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            //图像数据转换，使用了矩阵转换
            BitMatrix bitMatrix = new QRCodeWriter().encode(url, BarcodeFormat.QR_CODE, QR_WIDTH, QR_HEIGHT, hints);
            int[] pixels = new int[QR_WIDTH * QR_HEIGHT];
            //下面这里按照二维码的算法，逐个生成二维码的图片，
            //两个for循环是图片横列扫描的结果
            for (int y = 0; y < QR_HEIGHT; y++) {
                for (int x = 0; x < QR_WIDTH; x++) {
                    if (bitMatrix.get(x, y)) {
                        pixels[y * QR_WIDTH + x] = 0xff000000;
                    } else {
                        pixels[y * QR_WIDTH + x] = 0xffffffff;
                    }
                }
            }
            //生成二维码图片的格式，使用ARGB_8888
            bitmap = Bitmap.createBitmap(QR_WIDTH, QR_HEIGHT, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, QR_WIDTH, 0, 0, QR_WIDTH, QR_HEIGHT);
            //显示到一个ImageView上面

        } catch (WriterException e) {
            return bitmap;
        }

        return bitmap;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_identify_card);

        doInitTestData();
    }

    private void doInitTestData() {


        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.img_contact_bg);
        FunctionText functionText = new FunctionText();
        String target = functionText.getTargetName(selfContact.getContactName());
        ImgUtil.getInstance().getImgFromNetByUrl(selfContact.getAvatuar(), civ_user_head, new DrawableInText(target, 30, bitmap));

        tv_name.setText(selfContact.getContactName());


        iv_qr_identify_card.setImageBitmap(createQRImage(selfContact.getContactName()));
    }

    @Override
    protected PresenterQRCodeIdentifyCard creatPresenter() {

        if (null == presenterQRCodeIdentifyCard) {
            presenterQRCodeIdentifyCard = new PresenterQRCodeIdentifyCard(this);
        }

        return presenterQRCodeIdentifyCard;
    }

    @Override
    protected void initViews() {


        /**
         * titlle
         */
        iv_common_back = findOAViewById(R.id.iv_common_back);
        tv_common_title = findOAViewById(R.id.tv_common_title);
        tv_common_title.setText(R.string.qr_code_identify_card);


        tv_name = findOAViewById(R.id.tv_name);
        civ_user_head = findOAViewById(R.id.civ_user_head);
        iv_qr_identify_card = findOAViewById(R.id.iv_qr_identify_card);

    }

    @Override
    protected void initListener() {
        iv_common_back.setOnClickListener(this);
    }

    @Override
    protected void processIntent() {

        Intent intent = this.getIntent();
        if (null != intent) {

            Bundle bundle = intent.getExtras();

            if (null != bundle) {
                selfContact = (SelfContact) bundle.getSerializable(TestContent.TEST_BUNDLE_KEY);
            }
        }
    }

    @Override
    public void showLoadingDialog() {
        showLoadDialog();
    }

    @Override
    public void dismissLoadingDialog() {
        dismissLoadDialog();
    }

    @Override
    public void onDataBackFail(int code, String errorMsg) {
        ToastUtil.showMsg(getApplicationContext(), errorMsg);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.iv_common_back:
                dofinishItself();
                break;
        }
    }
}
