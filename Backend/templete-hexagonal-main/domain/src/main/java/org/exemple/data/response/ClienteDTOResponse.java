package org.exemple.data.response;

import lombok.*;
import org.exemple.data.ClienteDTO;
import org.exemple.data.DetallefacturaDTO;

import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ClienteDTOResponse {
    private List<ClienteDTO> listClienteDTO;
    private Message message;
}