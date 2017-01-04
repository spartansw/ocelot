package com.vistatec.ocelot.config.json;

import java.util.ArrayList;
import java.util.List;

public class OcelotRootConfig implements RootConfig {

	private List<PluginConfig> plugins;
	private ProvenanceConfig userProvenance;
	private TmManagement tmManagement;

	public OcelotRootConfig() {
		
		plugins = new ArrayList<PluginConfig>();
		userProvenance = new ProvenanceConfig();
		tmManagement = new TmManagement();
    }
	
	public void setPlugins(List<PluginConfig> plugins) {
		this.plugins = plugins;
	}

	public List<PluginConfig> getPlugins() {
		return plugins;
	}

	public void setUserProvenance(ProvenanceConfig userProvenance) {
		this.userProvenance = userProvenance;
	}

	public ProvenanceConfig getUserProvenance() {
		return userProvenance;
	}

	public void setTmManagement(TmManagement tmManagement) {
		this.tmManagement = tmManagement;
	}

	public TmManagement getTmManagement() {
		return tmManagement;
	}

	public void addPlugin(PluginConfig plugin) {

		if (plugin != null) {
			plugins.add(plugin);
		}
	}

	@Override
	public String toString() {

		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Ocelot Configuration:\n");
		if (tmManagement != null) {
			strBuilder.append(tmManagement.toString());
			strBuilder.append("\n");
		}
		if (userProvenance != null) {
			strBuilder.append(userProvenance.toString());
			strBuilder.append("\n");
		}
		if (plugins != null) {
			for (PluginConfig plugin : plugins) {
				strBuilder.append(plugin.toString());
				strBuilder.append("\n");
			}
		}
		return strBuilder.toString();
	}

}
