package com.mromer.establishment_microservice.common.domain.offering;

import java.math.BigDecimal;

import static com.mromer.establishment_microservice.common.domain.util.DomainValidationUtils.*;

public class Offering {

    private final OfferingId id;
    private final String name;
    private final String description;
    private final BigDecimal productionCost;
    private final BigDecimal salePrice;

    public Offering(OfferingId id,
                    String name,
                    String description,
                    BigDecimal productionCost,
                    BigDecimal salePrice) {
        this.id = requireNonNull(id, "Id");
        this.name = requireNotBlank(name, "Name");
        this.description = (description == null) ? "" : description.trim();
        this.productionCost = validatePositive(productionCost, "Production cost");
        this.salePrice = validatePositive(salePrice, "Sale price");

        validateCostRelation(this.productionCost, this.salePrice);
    }

    public OfferingId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getProductionCost() {
        return productionCost;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    private static void validateCostRelation(BigDecimal productionCost, BigDecimal salePrice) {
        if (productionCost.compareTo(salePrice) >= 0) {
            throw new IllegalArgumentException("Production cost must be less than sale price");
        }
    }
}

