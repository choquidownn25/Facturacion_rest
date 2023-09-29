package org.example.adapters;

import org.example.entity.Detallefactura;
import org.example.entity.Factura;
import org.example.mappers.DetallefacturaMapper;
import org.example.mappers.FacturaMapper;
import org.example.repository.DetallefacturaRepository;
import org.example.repository.FacturaRepository;
import org.exemple.data.DetallefacturaDTO;
import org.exemple.data.FacturaDTO;
import org.exemple.data.FacturaTotalDTO;
import org.exemple.data.FacturaTotalSubTotalDTO;
import org.exemple.ports.spi.DetalleFacturaPersistencePort;
import org.exemple.ports.spi.FacturaPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaJpaAdapter implements FacturaPersistencePort {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public FacturaDTO addDetalleFactura(FacturaDTO facturaDTO) {
        Factura factura = FacturaMapper.INSTANCE.facturaToFacturaDTO(facturaDTO);
        Factura response = facturaRepository.save(factura);
        FacturaDTO facturasDTO = FacturaMapper.INSTANCE.facturaDTOToFactura(response);
        return facturasDTO;
    }

    @Override
    public FacturaDTO updateDetalleFactura(FacturaDTO facturaDTO) {
        Factura factura = FacturaMapper.INSTANCE.facturaToFacturaDTO(facturaDTO);
        Factura response = facturaRepository.save(factura);
        FacturaDTO facturasDTO = FacturaMapper.INSTANCE.facturaDTOToFactura(response);
        return facturasDTO;
    }

    @Override
    public void removeDetalleFactura(Integer id) {
        facturaRepository.deleteById(id);
    }

    @Override
    public List<FacturaDTO> getDetalleFacturasList() {
        List<Factura>facturaList=facturaRepository.findAll();
        return FacturaMapper.INSTANCE.facturaDTOListToFacturaList(facturaList);
    }

    @Override
    public FacturaDTO getDetalleFacturasByDetalleFactura(Integer id) {
        //Encuentra el registro
        Optional<Factura> facturaId=facturaRepository.findById(id);
        if (facturaId.isPresent()) {
            return FacturaMapper.INSTANCE.facturaDTOToFactura(facturaId.get());
        }
        return null;
    }

    @Override
    public List<FacturaTotalDTO> calcularTotalesPorFactura(Integer facturaId) {
        List<FacturaTotalDTO> list = new ArrayList();
        FacturaTotalDTO facturaTotalDTO = new FacturaTotalDTO();
        for ( var facturaT : facturaRepository.calcularTotalesPorFactura(facturaId)) {
            facturaTotalDTO.setFacturaId(Integer.valueOf(facturaT[0].toString()));
            facturaTotalDTO.setSubtotal(Double.valueOf(facturaT[1].toString()));
            facturaTotalDTO.setTotal(Double.valueOf(facturaT[2].toString()));
            list.add(facturaTotalDTO);
        }
        return list;
    }

    @Override
    public List<Object[]> calcularSubtotalYTotalPorFactura(Integer facturaId) {
        return facturaRepository.calcularSubtotalYTotalPorFactura(facturaId);
    }

    @Override
    public List<FacturaTotalSubTotalDTO> subotalTotalesPorFactura(Integer facturaId) {
        List<FacturaTotalSubTotalDTO> list = new ArrayList();
        FacturaTotalSubTotalDTO facturaTotalDTO = new FacturaTotalSubTotalDTO();
        for ( var facturaT : facturaRepository.calcularSubtotalYTotalPorFactura(facturaId)) {
            facturaTotalDTO.setFacturaId(Integer.valueOf( facturaT[0].toString()));
            facturaTotalDTO.setFacturaFecha(Date.valueOf(facturaT[1].toString()));
            facturaTotalDTO.setClienteId(Integer.valueOf(facturaT[2].toString()));
            facturaTotalDTO.setClienteNombre(String.valueOf(facturaT[3].toString()));
            facturaTotalDTO.setProductoId(Integer.valueOf(facturaT[4].toString()));
            facturaTotalDTO.setProductoDescripcion(String.valueOf(facturaT[5].toString()));
            facturaTotalDTO.setCantidad(Integer.valueOf(facturaT[6].toString()));
            facturaTotalDTO.setPrecio(Double.valueOf(facturaT[7].toString()));
            facturaTotalDTO.setSubtotal(Double.valueOf(facturaT[8].toString()));
            facturaTotalDTO.setSubtotalTotal(Double.valueOf(facturaT[9].toString()));
            facturaTotalDTO.setTotalTotal(Double.valueOf(facturaT[10].toString()));
            list.add(facturaTotalDTO);
        }
        return list;
    }
}
