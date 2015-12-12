package com.example.markus.quakewatch;




        import android.graphics.Color;
        import android.graphics.PorterDuff;
        import android.graphics.drawable.Drawable;
        import android.support.v7.internal.view.menu.MenuView;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ContactViewHolder>
{
    public static View view;
    private List<ContactInfo> contactList;

    public CustomAdapter(List<ContactInfo> contactList) {
        this.contactList = contactList;
    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i)
    {
        ContactInfo ci = contactList.get(i);
        contactViewHolder.vort.setText(ci.ort);
        contactViewHolder.vtime.setText(ci.time);
        contactViewHolder.vdate.setText(ci.date);
        contactViewHolder.vstarke.setText(ci.starke);
        System.out.print("2111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_view_red, viewGroup, false);
       // ImageView v = (ImageView) itemView.findViewById(R.id.button_red);
        // v.setImageResource(R.drawable.button_yellow);
        System.out.print("1222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222");
        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder
    {

        protected TextView vort;
        protected TextView vdate;
        protected TextView vtime;
        protected TextView vstarke;

        public ContactViewHolder(View v)
        {
            super(v);
            view = v;
            vort = (TextView) v.findViewById(R.id.location);
            vdate = (TextView) v.findViewById(R.id.date);
            vtime = (TextView) v.findViewById(R.id.time);
            vstarke = (TextView) v.findViewById(R.id.starke);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v)
                {
                    v.scrollTo(0,0);
                }

            });
        }
    }
}