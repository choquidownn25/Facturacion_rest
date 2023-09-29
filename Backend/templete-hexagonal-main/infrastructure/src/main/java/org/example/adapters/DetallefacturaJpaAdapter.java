package org.example.adapters;

import org.example.entity.Detallefactura;
import org.example.mappers.DetallefacturaMapper;
import org.example.repository.DetallefacturaRepository;
import org.exemple.data.DetallefacturaDTO;
import org.exemple.ports.spi.DetalleFacturaPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DetallefacturaJpaAdapter implements DetalleFacturaPersistencePort {

    @Autowired
    private DetallefacturaRepository detallefacturaRepository;

    @Override
    public DetallefacturaDTO addDetalleFactura(DetallefacturaDTO detallefacturaDTO) {
        Detallefactura detallefactura = DetallefacturaMapper.INSTANCE.detallefacturaToDetallefacturaDTO(detallefacturaDTO);
        Detallefactura response = detallefacturaRepository.save(detallefactura);
        DetallefacturaDTO detallefacturasDTO = DetallefacturaMapper.INSTANCE.detallefacturaDTOToDetallefactura(response);
        return detallefacturasDTO;
    }

    @Override
    public DetallefacturaDTO updateDetalleFactura(DetallefacturaDTO detallefacturaDTO) {
        Detallefactura detallefactura = DetallefacturaMapper.INSTANCE.detallefacturaToDetallefacturaDTO(detallefacturaDTO);
        Detallefactura response = detallefacturaRepository.save(detallefactura);
        DetallefacturaDTO detallefacturasDTO = DetallefacturaMapper.INSTANCE.detallefacturaDTOToDetallefactura(response);
        return detallefacturasDTO;
    }

    @Override
    public void removeDetalleFactura(Integer id) {
        detallefacturaRepository.deleteById(id);
    }

    @Override
    public List<DetallefacturaDTO> getDetalleFacturasList() {
        List<Detallefactura>detallefacturaList=detallefacturaRepository.findAll();
        return DetallefacturaMapper.INSTANCE.detallefacturaDTOListoDetallefacturaList(detallefacturaList);
    }

    @Override
    public DetallefacturaDTO getDetalleFacturasByDetalleFactura(Integer id) {
        //Encuentra el registro
        Optional<Detallefactura> detallefacturaId=detallefacturaRepository.findById(id);
        if (detallefacturaId.isPresent()) {
            return DetallefacturaMapper.INSTANCE.detallefacturaDTOToDetallefactura(detallefacturaId.get());
        }
        return null;
    }
    public Double calcularTotalPorCodigoFactura(Integer codigoFactura) {
        List<Detallefactura> detalles = detallefacturaRepository.findAllById(Collections.singleton(codigoFactura));
        double total = 0.0;

        for (Detallefactura detalle : detalles) {
            total += detalle.getPrecio() * detalle.getCantidad();
        }

        return total;
    }
}
