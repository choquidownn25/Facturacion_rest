package org.exemple.data.response;

import lombok.*;
import org.exemple.data.ProductoDTO;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class ProductoDTOResponse {
    private List<ProductoDTO> listProductoDTO;
    private Message message;
}