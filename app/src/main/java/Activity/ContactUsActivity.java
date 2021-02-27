package Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.shahbatech.lasirene.R;

public class ContactUsActivity extends BaseActivity {

    private static final String PHONE_NUMBER = "+917490844738";
    private static final String WEB = "https://www.lasirene.ae";
    private static final String EMAIL = "https://www.lasirene.ae";
    private static final String TWITTER = "https://www.twitter.com/lasirene";
    private static final String FACEBOOK = "https://www.facebook.com/lasirene";
    private static final String INSTAGRAM = "https://www.instagram.com/lasirene";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        findViewById(R.id.number).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + PHONE_NUMBER));
            startActivity(intent);
        });


        findViewById(R.id.web).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(WEB));
            if(intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }
        });


        findViewById(R.id.email).setOnClickListener(v -> {
            String[] addresses = {EMAIL};
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, addresses);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Information request");
            intent.putExtra(Intent.EXTRA_TEXT, "Please send some information!");
            if(intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }
        });



        findViewById(R.id.twitter).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(TWITTER));
            if(intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }
        });

        findViewById(R.id.facebook).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(FACEBOOK));
            if(intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }
        });

        findViewById(R.id.instagram).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(INSTAGRAM));
            if(intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }
        });
    }
}
