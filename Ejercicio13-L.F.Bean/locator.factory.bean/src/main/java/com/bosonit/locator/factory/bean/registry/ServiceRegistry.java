package com.bosonit.locator.factory.bean.registry;

public interface ServiceRegistry {
    public <T> AdapterService<T> getService(String serviceName);
}
