package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.shahbatech.apiwrapper.model.ProductDetail;
import com.shahbatech.lasirene.R;

import java.util.ArrayList;
import java.util.List;

import Activity.BaseToolbarActivity;
import Utilities.Helper.Cache;
import Utilities.Helper.CustomDate;
import Utilities.Service.CartService;


public class ProductDetailsAdapter extends RecyclerView.Adapter<ProductDetailsAdapter.MyViewHolder>{

    private Context context;
    private List<ProductDetail> OfferList = new ArrayList<>();
    private int Offer = 0;


    public ProductDetailsAdapter(Context context) {
        this.context = context;
    }

    public void addAll(List<ProductDetail> categories, int offer) {
        Offer = offer;
        OfferList = categories;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {



        TextView name, price, time;
        LinearLayout addToCart;

        public MyViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.name);
            price = view.findViewById(R.id.price);
            time = view.findViewById(R.id.time);
            addToCart = view.findViewById(R.id.add_to_cart);
        }

    }



    @Override
    public ProductDetailsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product_detail, parent, false);

        return new ProductDetailsAdapter.MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull final ProductDetailsAdapter.MyViewHolder holder, int position) {
        ProductDetail item = OfferList.get(position);

        holder.name.setText(item.getName());

        String price = item.getFromPrice() * (1 - Offer / 100.0) + " - " + item.getToPrice() * (1 - Offer / 100.0) + "AED";
        holder.price.setText(price);

        String time = CustomDate.time( item.getFromTime() ) + " - " + CustomDate.time( item.getToTime() );
        holder.time.setText(time);

        holder.addToCart.setOnClickListener(view -> {
            CartService cartService = CartService.Create();
            cartService.addToCart(item);
            Toast.makeText(context, context.getResources().getString(R.string.serivce_has_been_added), Toast.LENGTH_LONG).show();
            ((BaseToolbarActivity) context).showDotCart();
        });

    }



    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}


