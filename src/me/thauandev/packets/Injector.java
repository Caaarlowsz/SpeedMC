package me.thauandev.packets;

import org.bukkit.entity.Player;



public class Injector {

	private Handler	handler;

	public boolean inject() {
		try {
			Class.forName("net.minecraft.util.io.netty.channel.Channel");
			this.handler = new NMUHandler();
			return true;
		} catch (Exception e) {

		}
		try {
			Class.forName("io.netty.channel.Channel");
			this.handler = new INCHandler();
			return true;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public void addChannel(Player p) {
		this.handler.addChannel(p);
	}

	public void removeChannel(Player p) {
		this.handler.removeChannel(p);
	}

	public void addServerConnectionChannel() {
		this.handler.addServerConnectionChannel();
	}

}
