package com.api.request.model;

import java.util.Arrays;

public record CreateJobPayload(
    int mst_service_location_id,
    int mst_platform_id,
    int mst_warrenty_status_id,
    int mst_oem_id,

    Customer customer,
    CustomerAddress customer_address,
    CustomerProduct customer_product,
    Problems[] problems
) {
    @Override
    public String toString() {
        return "CreateJobPayload{" +
                "mst_service_location_id=" + mst_service_location_id +
                ", mst_platform_id=" + mst_platform_id +
                ", mst_warrenty_status_id=" + mst_warrenty_status_id +
                ", mst_oem_id=" + mst_oem_id +
                ", customer=" + customer +
                ", customer_address=" + customer_address +
                ", customer_product=" + customer_product +
                ", problems=" + Arrays.toString(problems) +
                '}';
    }
}
