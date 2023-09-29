package org.exemple.data.response;

import lombok.*;
import org.exemple.data.DetallefacturaDTO;
import org.exemple.data.FacturaDTO;

import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class DetallefacturaDTOResponse {
    private List<DetallefacturaDTO> listDetallefacturaDTO;
    private Message message;
}