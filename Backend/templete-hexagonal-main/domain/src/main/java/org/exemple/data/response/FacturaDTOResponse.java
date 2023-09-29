package org.exemple.data.response;

import lombok.*;
import org.exemple.data.FacturaDTO;
import org.exemple.data.ProductoDTO;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class FacturaDTOResponse {
    private List<FacturaDTO> listFacturaDTO;
    private Message message;
}