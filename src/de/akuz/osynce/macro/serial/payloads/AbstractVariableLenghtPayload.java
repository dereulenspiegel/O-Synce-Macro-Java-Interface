package de.akuz.osynce.macro.serial.payloads;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a payload with a variable length. Bytes can be added in
 * a list. Note the method getBytes returns a byte array, but manipulation
 * to this byte array isn't reflected in in the payload
 * @author Till Klocke
 *
 */
public abstract class AbstractVariableLenghtPayload extends AbstractPayload {
	
	protected List<Byte> dataBytes = new LinkedList<Byte>();
	
	@Override
	public byte[] getBytes() {
		byte[] array = new byte[dataBytes.size()];
		for(int i = 0; i < dataBytes.size(); i++){
			array[i] = dataBytes.get(i);
		}
		return array;
	}

	@Override
	public void writeBytesToData(byte[] value, int byteOffset, int offset,
			int length) {
		for(int i=value.length;i>0;i--){
			insertByteToList(offset+(length-(i+1)),value[i+byteOffset]);
		}
	}
	
	/**
	 * Inserts a byte into the List of bytes at the specified index.
	 * If the index is higher than lists size bytes with zero value are
	 * inserted
	 * @param index
	 * @param b
	 */
	private void insertByteToList(int index, byte b){
		if(index == dataBytes.size()){
			dataBytes.add(b);
		} else if(index>dataBytes.size()){
			for(int i=dataBytes.size();i<index;i++){
				dataBytes.add((byte)0x00);
			}
			dataBytes.add(b);
		} else if(index < dataBytes.size()){
			dataBytes.set(index, b);
		}
	}

	@Override
	public void writeBytesToData(byte[] value, int offset, int length) {
		writeBytesToData(value, 0, offset, length);
	}

	@Override
	public void writeByteToData(byte value, int offset) {
		writeBytesToData(new byte[]{value},0,offset,1);
	}

	@Override
	public byte[] getBytesFromPosition(int position, int count) {
		byte[] array = new byte[count];
		
		for(int i=0;i<count;i++){
			array[i] = dataBytes.get(i);
		}
		
		return array;
	}

	@Override
	public byte getByteFromPosition(int position) {
		return getBytesFromPosition(position,1)[0];
	}

	@Override
	public int getLength() {
		return dataBytes.size();
	}

}
