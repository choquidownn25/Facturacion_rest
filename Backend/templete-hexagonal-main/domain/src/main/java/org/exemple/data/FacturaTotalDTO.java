package org.exemple.data;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor

public class FacturaTotalDTO {
    private Integer facturaId;
    private Double subtotal;
    private Double total;

    public FacturaTotalDTO(Integer facturaId, Double subtotal, Double total) {
        this.facturaId = facturaId;
        this.subtotal = subtotal;
        this.total = total;
    }
}
