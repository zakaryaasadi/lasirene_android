package com.shahbatech.apiwrapper.model;

import java.util.List;

public class Booking extends BaseModel
{
    public int customer_id;

    public String location;

    public String date;

    public List<BookingDetail> details;
}
