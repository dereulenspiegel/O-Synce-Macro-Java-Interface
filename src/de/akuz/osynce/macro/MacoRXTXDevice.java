package de.akuz.osynce.macro;

import java.util.Map;

import de.akuz.osynce.macro.serial.RXTXSerialPortDevice;

public class MacoRXTXDevice extends AbstractMacroSerialPortDevice{

	@Override
	public void init(Map<String, String> properties) {
		this.device = new RXTXSerialPortDevice();
		this.portName = properties.get(PROPERTY_PORTNAME);
		if(portName == null){
			throw new IllegalArgumentException("Property portname not specified");
		}
		
	}

}
