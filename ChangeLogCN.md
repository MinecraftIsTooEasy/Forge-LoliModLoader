# FishModLoader

### v3.5.0
* mapping改用mcp mapping
* 以下Enum支持拓展
  * EnumGameType
  * EnumLevelBonus
  * EnumQuality
  * EnumSpecialSplash
* 修改了自带@Mixin类的包名与类名
* 支持读取fabric.mod.json
* 支持classloader

---

### v3.3.3
* 配置文件目录修改为.minecraft/config
* MITE的modid修改为minecraft,版本修改为1.6.4-mite(可能导致部分mod不可用)
* 修复了进服务器无法触发PlayerLoggedInEvent的问题
* 为EnumExtends添加了EnumOptions