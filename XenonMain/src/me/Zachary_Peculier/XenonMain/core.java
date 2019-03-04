package me.Zachary_Peculier.XenonMain;

import java.util.ArrayList;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class core extends JavaPlugin
{
    public final java.util.logging.Logger logger = Logger.getLogger("Minecraft");
    public static core plugin;
    public final MyPlayerListener mpl = new MyPlayerListener();
    ArrayList<String> toggled = new ArrayList<String>();

    @Override
    public void onDisable()
    {
        PluginDescriptionFile pdFile = this.getDescription();
        this.logger.info(pdFile.getName() + " Version " + pdFile.getVersion() + " Has Been Deactivated!");
        getServer().clearRecipes();
    }

    @SuppressWarnings(
    { "deprecation" })
    public void onEnable()
    {
        PluginDescriptionFile pdFile = this.getDescription();
        this.logger.info(pdFile.getName() + " Version " + pdFile.getVersion() + " Has Been Activated!");
        org.bukkit.plugin.PluginManager plm = this.getServer().getPluginManager();
        plm.registerEvents(new MyPlayerListener(), this);
        ItemStack milkStack = new ItemStack(Material.MUSHROOM_SOUP);
        ItemMeta milkMeta = milkStack.getItemMeta();
        milkMeta.setDisplayName((new StringBuilder()).append(ChatColor.RESET).append("Cocoa Soup").toString());
        milkStack.setItemMeta(milkMeta);
        ShapelessRecipe milk = new ShapelessRecipe(milkStack);
        milk.addIngredient(1, Material.INK_SACK, 3);
        milk.addIngredient(1, Material.BOWL);
        getServer().addRecipe(milk);
        plm.registerEvents(this.mpl, this);
        getServer().getWorld("hardcore").setSpawnLocation(0, 69, 0);
    }

    @SuppressWarnings(
    { "deprecation" })
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        ItemStack dSword500 = new ItemStack(Material.DIAMOND_SWORD);
        dSword500.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 500);
        dSword500.addUnsafeEnchantment(Enchantment.KNOCKBACK, 500);
        dSword500.addUnsafeEnchantment(Enchantment.DURABILITY, 500);
        dSword500.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 500);
        dSword500.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 500);
        ItemStack arrow = new ItemStack(Material.ARROW);
        ItemStack torch = new ItemStack(Material.TORCH, 64);
        ItemStack bow500 = new ItemStack(Material.BOW);
        bow500.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 500);
        bow500.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 500);
        bow500.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 500);
        ItemStack hat = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack chestpiece = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack pants = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack shoes = new ItemStack(Material.DIAMOND_BOOTS);
        hat.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5000);
        chestpiece.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5000);
        pants.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5000);
        shoes.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5000);
        hat.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1000);
        chestpiece.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5000);
        pants.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5000);
        shoes.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5000);
        hat.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5000);
        chestpiece.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5000);
        pants.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5000);
        shoes.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5000);
        hat.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 500);
        chestpiece.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 5000);
        pants.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 5000);
        shoes.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 5000);
        hat.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5000);
        chestpiece.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5000);
        pants.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5000);
        shoes.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 5000);
        hat.addUnsafeEnchantment(Enchantment.DURABILITY, 5000);
        chestpiece.addUnsafeEnchantment(Enchantment.DURABILITY, 5000);
        pants.addUnsafeEnchantment(Enchantment.DURABILITY, 5000);
        shoes.addUnsafeEnchantment(Enchantment.DURABILITY, 5000);
        final Player player = (Player) sender;
        for (Player players : getServer().getOnlinePlayers())
            if (commandLabel.equalsIgnoreCase("IP"))
            {
                if (player.hasPermission("xenonmain.IP"))
                {
                    if (args.length == 0)
                    {
                        player.sendMessage("Please name player");
                        return true;
                    }
                    else if (args.length == 1)
                    {
                        Player tplayer = getServer().getPlayer(args[0]);
                        player.sendMessage(ChatColor.AQUA + "IP: " + tplayer.getAddress());
                    }
                    return true;
                }
                else
                {
                    player.sendMessage(ChatColor.DARK_RED + "No Permissions!");
                    return true;
                }
            }
            else if (commandLabel.equalsIgnoreCase("timer"))
            {
                if (player instanceof Player)
                {
                    if (player.hasPermission("xenonmain.count"))
                    {
                        if (args.length == 0)
                        {
                            player.sendMessage(ChatColor.RED + "Usage: /timer <number>");
                            return true;
                        }
                        else if (args.length == 1)
                        {
                            if (isInt(args[0]))
                            {
                                int timer = Integer.parseInt(args[0]);
                                player.sendMessage(ChatColor.DARK_RED + "Starting " + args[0] + " second countdown!");
                                this.getServer().getScheduler().scheduleAsyncRepeatingTask(this, new Runnable()
                                {
                                    public void run()
                                    {
                                        int number = timer;
                                        if (number != -1)
                                        {
                                            {
                                                if (number != 0)
                                                {
                                                    Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "[Server] " + number);
                                                    number--;
                                                }
                                                else
                                                {
                                                    Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "[Server] Go!");
                                                    number--;
                                                }
                                            }
                                        }
                                    }
                                }, 0L, 20L);
                                return true;
                            }
                            else
                            {
                                player.sendMessage(ChatColor.RED + "Please enter a whole number");
                            }
                        }
                    }
                    else
                    {
                        player.sendMessage(ChatColor.DARK_RED + "No Permissions!");
                        return true;
                    }
                }
            }
            else if (commandLabel.equalsIgnoreCase("ops"))
            {
                if (player.hasPermission("xenonmain.500"))
                {
                    player.sendMessage(ChatColor.YELLOW + "Have fun :)");
                    player.getInventory().addItem(dSword500);
                    return true;
                }
                else
                {
                    player.sendMessage(ChatColor.DARK_RED + "No Permissions!");
                }
            }
            else if (commandLabel.equalsIgnoreCase("opp"))
            {
                if (player.hasPermission("xenonmain.500"))
                {
                    if (args.length == 0)
                    {
                        player.sendMessage(ChatColor.RED + "Please name player");
                    }
                    else if (args.length == 1)
                    {
                        Player tplayer = getServer().getPlayer(args[0]);
                        tplayer.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 500, 500));
                        tplayer.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 500, 500));
                        tplayer.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 500, 500));
                        tplayer.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 500, 500));
                        tplayer.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 500, 500));
                        tplayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 500, 500));
                        tplayer.sendMessage(ChatColor.GRAY + ("May Notch have mercy on your soul."));
                        return true;
                    }
                }
                else
                {
                    player.sendMessage(ChatColor.DARK_RED + "No Permissions!");
                }
            }
            else if (commandLabel.equalsIgnoreCase("admin"))
            {
                if (player.hasPermission("xenonmain.admin"))
                {
                    if (toggled.contains(player.getName()))
                    {
                        for (Player p : Bukkit.getOnlinePlayers())
                            p.showPlayer(player);
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(ChatColor.BLUE + "You are now in player mode.");
                        toggled.remove(player.getName());
                        return true;
                    }
                    for (Player p : Bukkit.getOnlinePlayers())
                        p.hidePlayer(player);
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.RED + "You are now in admin mode.");
                    toggled.add(player.getName());
                    return true;
                }
                else
                {
                    player.sendMessage(ChatColor.RED + "No Permissions!");
                }
            }
            else if (commandLabel.equalsIgnoreCase("kill"))
            {
                player.sendMessage(ChatColor.RED + "Command disabled!");
                return true;
            }
            else if (commandLabel.equalsIgnoreCase("moderator"))
            {
                if (player.hasPermission("xenonmain.mod"))
                {
                    if (toggled.contains(player.getName()))
                    {
                        for (Player p : Bukkit.getOnlinePlayers())
                            p.showPlayer(player);
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(ChatColor.BLUE + "You are now in player mode.");
                        toggled.remove(player.getName());
                        return true;
                    }
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.DARK_PURPLE + "You are now in moderator mode.");
                    toggled.add(player.getName());
                    return true;
                }
                else
                {
                    player.sendMessage(ChatColor.RED + "No Permissions!");
                    return true;
                }
            }
            else if (commandLabel.equalsIgnoreCase("clearchat"))
            {
                if (player.hasPermission("xenonmain.clear"))
                {
                    for (int i = 0; i < 1000; i++)
                    {
                        Bukkit.broadcastMessage("");
                    }
                    Bukkit.broadcastMessage(ChatColor.GRAY + "Chat cleared by " + player.getName());
                    return true;
                }
                else
                {
                    player.sendMessage(ChatColor.RED + "No Permissions!");
                    return true;
                }
            }
            else if (commandLabel.equalsIgnoreCase("kick"))
            {
                if (player.hasPermission("xenonmain.kick"))
                {
                    if (args.length <= 1)
                    {
                        player.sendMessage(ChatColor.RED + "Usage: /kick <player> <reason>");
                        return true;
                    }
                    else if (args.length > 1)
                    {
                        String message = "";
                        for (int i = 1; i < args.length; ++i)
                        {
                            message += args[i] + " ";
                        }
                        Player tplayer = getServer().getPlayer(args[0]);
                        tplayer.kickPlayer(ChatColor.RED + "You have been kicked " + message + ".");
                        Bukkit.broadcastMessage(ChatColor.GRAY + tplayer.getName() + " was kicked.");
                        return true;
                    }
                }
            }
            else if (commandLabel.equalsIgnoreCase("opb"))
            {
                if (player.hasPermission("xenonmain.500"))
                {
                    player.getInventory().addItem(bow500);
                    player.getInventory().addItem(arrow);
                    player.sendMessage(ChatColor.YELLOW + "Have fun :)");
                    return true;
                }
                else
                {
                    player.sendMessage(ChatColor.RED + "No Permissions!");
                    return true;
                }
            }
            else if (commandLabel.equalsIgnoreCase("opa"))
            {
                if (player.hasPermission("xenonmain.500"))
                {
                    player.getInventory().addItem(hat);
                    player.getInventory().addItem(chestpiece);
                    player.getInventory().addItem(pants);
                    player.getInventory().addItem(shoes);
                    player.sendMessage(ChatColor.BLACK + "Can't touch this, doom doom doom doom.");
                    return true;
                }
                else
                {
                    player.sendMessage(ChatColor.RED + "No Permissions!");
                    return true;
                }
            }
            else if (commandLabel.equalsIgnoreCase("say"))
            {
                if (player.hasPermission("xenonmain.say"))
                {
                    if (args.length == 0)
                    {
                        player.sendMessage(ChatColor.RED + "Usage: /say <message>");
                        return true;
                    }
                    else if (args.length >= 1)
                    {
                        String message = "";
                        for (int i = 0; i < args.length; ++i)
                        {
                            message += args[i] + " ";
                        }
                        Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "[Server] " + message);
                        return true;
                    }
                }
                else
                {
                    player.sendMessage(ChatColor.RED + "No Permissions!");
                    return true;
                }
            }
            else if (commandLabel.equalsIgnoreCase("gexe"))
            {
                if (player.hasPermission("xenonmain.gexe"))
                {
                    if (args.length == 0)
                    {
                        player.sendMessage(ChatColor.RED + "Usage: /gexe <command>");
                        return true;
                    }
                    else if (args[0].equalsIgnoreCase("tp"))
                    {
                        {
                            players.teleport(player.getLocation());
                            return true;
                        }
                    }
                }
            }
            else if (commandLabel.equalsIgnoreCase("me"))
            {
                player.sendMessage(ChatColor.RED + "Command disabled!");
                return true;
            }
            else if (commandLabel.equalsIgnoreCase("torch"))
                if (player.hasPermission("xenonmain.torch"))
                {
                    {
                        player.getInventory().addItem(torch);
                        return true;
                    }
                }
                else
                {
                    player.sendMessage(ChatColor.RED + "No Permissions!");
                }
            else if (commandLabel.equalsIgnoreCase("s"))
            {
                if (player.hasPermission("xenonmain.teleport"))
                {
                    if (args.length == 0)
                    {
                        player.sendMessage(ChatColor.RED + "Usage: /s <player>");
                        return true;
                    }
                    else if (args.length == 1)
                    {
                        Player tplayer = getServer().getPlayer(args[0]);
                        Location playerLocation = player.getLocation();
                        tplayer.teleport(playerLocation);
                        getServer().broadcast(ChatColor.ITALIC + "" + ChatColor.GRAY + "[" + player.getName() + ": Teleported " + tplayer.getName() + " to " + player.getName() + "]", "xenonmain.msg");
                        return true;
                    }
                }
                else
                {
                    player.sendMessage(ChatColor.RED + "No Permissions!");
                    return true;
                }
            }
            else if (commandLabel.equalsIgnoreCase("heal"))
            {
                player.sendMessage(ChatColor.RED + "Command Disabled!");
                return true;
            }
            else if (commandLabel.equalsIgnoreCase("god"))
            {
                player.sendMessage(ChatColor.RED + "Command Disabled!");
                return true;
            }
        return true;
    }

    private boolean isInt(String string)
    {
        try
        {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }
}