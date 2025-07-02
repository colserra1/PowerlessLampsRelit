# PowerlessLampsRelit

## About

PowerlessLampsRelit is a plugin for Paper Minecraft servers that can create continously powered Redstone Lamps and Copper Bulbs without a power source. It is intended as a spiritual successor to the original [PowerlessLamps](https://www.spigotmc.org/resources/powerlesslamps.7341/) and was originally developed based on the approach of [PowerlessLampsRedux](https://github.com/moikheck/PowerlessLampsRedux).
This plugin adds WorldEdit interconnectivity and allows the user to toggle or turn on/off all lamps/bulbs within a WE selection.

## Usage

On a basic level, the plugin allows users that have the appropriate permission to right-click a lightable block to toggle its state. Additionally, there are commands available to interface with the user's WorldEdit selection.

### Commands

`/lamps` and `/lamp` are aliases.

#### General Commands

-  `/lamps toggle` :   
   Toggle the state of all lightables within the current WorldEdit selection  

- `/lamps on` :  
   Turn on all lightables within the current WorldEdit selection 

- `/lamps off` :  
   Turn off all lightables within the current WorldEdit selection

- `/lamps reload` :  
   Reloads the config, currently only used to enable/disable permission requirements
  
### Permissions

- `lamps.reload:` - Allows the user to reload the config 
- `lamps.toggle:` - Allows the user to use the features of the plugin 

## Installation

To install PowerlessLampsRelit, download the latest release and place the JAR file in your server plugins folder and restart your server.  

This plugin has WorldEdit as a dependency, currently there is no option to use it as a standalone tool.

The plugin depends on paperweight and NMS components, so compatibility may break with major version updates. 
  
## Notice
Thanks to [moikheck](https://github.com/moikheck) for creating [PowerlessLampsRedux](https://github.com/moikheck/PowerlessLampsRedux) which I used as the basis for this project.
