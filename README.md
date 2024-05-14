# CustomRtp
![Minecraft](https://img.shields.io/badge/Minecraft-1.20+-brightgreen.svg)
![Spigot](https://img.shields.io/badge/Paper-1.20+-white.svg)

![Untitled design](https://github.com/s5y-ux/CustomRtp/assets/59636597/1517f162-dbb6-41ec-9c9a-f89138d8a8a6)


**Version:** 1.0  
**API Version:** 1.20  
**Author:** Joseph R. Shumaker (s5y)  

CustomRtp is a simple Minecraft plugin that teleports players to a random location within a specified distance. The plugin allows for customizable sound effects and messages when the teleportation occurs.

## Features

- Teleports players to random locations.
- Customizable maximum teleportation distance.
- Customizable sound effects.
- Customizable messages with color codes.

## Configuration

The configuration file `config.yml` supports the following options:

- **Distance**: Maximum distance to teleport (-Distance to +Distance).
- **SoundEffect**: The sound effect to play when teleporting.  
  - Options: `enderman`, `explosion`, `levelup`, `anvil`.
- **CustomMessage**: The message to display when teleporting.  
  - Supports color codes.

## Commands

- `/rtp`: Teleports the player to a random location.  
  - **Permission**: `CustomRtp.teleport`

## Setup

1. Download and install [Spigot](https://www.spigotmc.org/).
2. Place the `CustomRtp` plugin jar file into your server's `plugins` directory.
3. Start or restart your server to load the plugin.

## Usage

1. In-game, use `/rtp` to teleport to a random location.

## License

This project is licensed under the Eclipse Public License - v 2.0 - see the [LICENSE](LICENSE) file for details..
