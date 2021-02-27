package Activity;

import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shahbatech.apiwrapper.model.Booking;
import com.shahbatech.apiwrapper.model.BookingDetail;
import com.shahbatech.lasirene.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;

import Adapter.CartAdapter;
import Model.CartModel;
import Utilities.Helper.Cache;
import Utilities.Helper.Defaults;
import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends BaseToolbarActivity {

    private CartAdapter bAdapter;
    private RecyclerView recyclerView;
    private View noItemFoundView;
    private Calendar defaultDate;
    private DatePickerDialog dpd;
    private Calendar minDate;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_cart);
        super.onCreate(savedInstanceState);

        setToolbarTitle(R.string.cart);

        noItemFoundView = findViewById(R.id.no_item_found_view);
        findViewById(R.id.submit).setOnClickListener(v -> {
            showAlert();
        });


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        bAdapter = new CartAdapter(this);
        recyclerView.setAdapter(bAdapter);

        statusNoItemView();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void showAlert() {
        SubmitAlertDialog alertDialog = new SubmitAlertDialog(this);
        alertDialog.create().show();
    }



    public void statusNoItemView(){
        noItemFoundView.setVisibility(Cache.cartList.isEmpty() ? View.VISIBLE : View.GONE);
        findViewById(R.id.layout_submit).setVisibility(Cache.cartList.isEmpty() ? View.GONE : View.VISIBLE);
    }




}
