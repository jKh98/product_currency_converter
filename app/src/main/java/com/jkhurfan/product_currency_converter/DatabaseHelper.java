package com.jkhurfan.product_currency_converter;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DatabaseHelper {

    private DatabaseReference mDatabase;

    public DatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance().getReference().child("products");
        Log.v("mDatabase", mDatabase.toString());
    }

    public DatabaseReference getReference(){
        return mDatabase;
    }

    public void addNewProduct(String barcode, String name, String description, double cost) {
        Product product = new Product(barcode, name, description, cost);

        mDatabase.child(barcode).setValue(product);
    }

    public void updateProductName(String barcode, String name) {
        mDatabase.child("products").child(barcode).child("name").setValue(name);
    }

    public void updateProductDescription(String barcode, String description) {
        mDatabase.child("products").child(barcode).child("description").setValue(description);
    }

    public void updateProductCost(String barcode, double cost) {
        mDatabase.child("products").child(barcode).child("cost").setValue(cost);
    }
}
