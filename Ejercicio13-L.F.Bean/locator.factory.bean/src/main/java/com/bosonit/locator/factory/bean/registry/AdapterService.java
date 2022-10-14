package com.bosonit.locator.factory.bean.registry;

import com.bosonit.locator.factory.bean.model.Vehicle;

public interface AdapterService<T>{
    public void process(T request);

   // String process(Vehicle request);
}
