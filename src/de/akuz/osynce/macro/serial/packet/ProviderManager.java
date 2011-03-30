package de.akuz.osynce.macro.serial.packet;

import java.util.HashMap;
import java.util.Map;

import de.akuz.osynce.macro.serial.interfaces.Packet;

/**
 * The ProviderManager manages the PacketProvider.
 * @author Till Klocke
 *
 */
public class ProviderManager {
	
	/**
	 * Interface for Classes responsible for parsing packets from bytearrays.
	 * @author Till Klocke
	 *
	 */
	public interface PacketProvider {
		
		/**
		 * Method called by PacketProvider to parse a packet.
		 * The array does contain the command byte.
		 * @param array
		 * @return
		 */
		public Packet parse(byte[] array);
		
		/**
		 * Returns an empty packet specified by command.
		 * @param command Command which specifies the type of the packet
		 * @return empty packet, ready to be fed with data
		 */
		public Packet getEmptyPacket(byte command);
	}
	
	private final Map<Byte,PacketProvider> providers =
		new HashMap<Byte,PacketProvider>();
	
	private final static ProviderManager instance = new ProviderManager();
	
	/**
	 * Inaccessible constructor to enforce singleton
	 */
	private ProviderManager(){
		
	}
	
	/**
	 * Returns the singleton instance
	 * @return
	 */
	public static ProviderManager getInstance(){
		return instance;
	}
	
	/**
	 * The default packet provider. This provider generates GenericPackets
	 * and is used when no other provider does match
	 */
	private final PacketProvider defaultProvider = 
		new DefaultPacketProvider();
	
	/**
	 * Registers a packet provider for a specific command byte
	 * @param command
	 * @param provider
	 */
	public void registerPacketProvider(byte command, 
			PacketProvider provider){
		providers.put(command, provider);
	}
	
	/**
	 * Unregisters the packet provider for a specific command byte
	 * @param command
	 */
	public void unregisterPacketProvider(Commands command){
		providers.remove(command);
	}
	
	/**
	 * Returns the packet provider for a specific command byte or the
	 * default packet provider
	 * @param command
	 * @return
	 */
	public PacketProvider getProvider(byte command){
		if(providers.containsKey(command)){
			return providers.get(command); 
		}
		return defaultProvider;
	}
	
	/**
	 * Parses a packet from a complete byte array.
	 * @param array
	 * @return
	 */
	public Packet parsePacket(byte[] array){
		return getProvider(array[0]).parse(array);
	}
	
	public Packet getEmptyPacket(byte command){
		return getProvider(command).getEmptyPacket(command);
	}

}
