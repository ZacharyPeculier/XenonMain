package me.Zachary_Peculier.XenonMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerQuitEvent;

@SuppressWarnings("deprecation")
public class MyPlayerListener implements Listener
{
	public int chat;
	public static core plugin;
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		if(player.hasPlayedBefore())
		{	
			event.setJoinMessage(ChatColor.GREEN + player.getName() + ChatColor.RESET + " / " + ChatColor.DARK_GRAY + "has logged in!");
		}
		else
		{
			event.setJoinMessage(ChatColor.GOLD + "Welcome " + player.getName() + " to MCRaid!");
			player.sendMessage("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         ");
			player.sendMessage(ChatColor.DARK_RED + "PLEASE NOTE: YOU CAN BE BANNED FOR HACKING/RACISM/SPAMMING/ADVERTISING/ETC. YOU HAVE BEEN WARNED!!!!!");
			player.sendMessage(ChatColor.DARK_RED + "Just use common sense, and you won't get banned.");
			player.sendMessage(ChatColor.DARK_GREEN +"Welcome to MCRaid! :)");
		}
		}
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLogin(PlayerLoginEvent event) 
	{
		if (event.getPlayer().isBanned()) 
		{
			event.disallow(PlayerLoginEvent.Result.KICK_BANNED, ChatColor.RED + "You are banned. You may apply for an appeal at http://www.mcraid.com");
			return;
		}		
	}
	@EventHandler
	public void join(PlayerQuitEvent event)
	{
		Player player = event.getPlayer();
		event.setQuitMessage(ChatColor.GREEN + player.getName() + ChatColor.RESET + " / " + ChatColor.DARK_GRAY + "has logged out!");
	}
	@EventHandler
	public void handleKicks(PlayerLoginEvent event) 
	{
	if(event.getResult() == Result.KICK_WHITELIST) event.setKickMessage(ChatColor.RED + "The server is currently " + ChatColor.DARK_RED + "LOCKED" + ChatColor.RED + " for maintainence. Please check back later. Sorry for any inconvenience! :S");
	else if(event.getResult() == Result.KICK_FULL) event.setKickMessage(ChatColor.AQUA + "Server is full!!!!" + ChatColor.YELLOW + "Go to http://www.mcraid.com and Donate to join while full!!");
	else if(event.getResult() == Result.KICK_BANNED) event.setKickMessage(ChatColor.RED + "You are banned from the server. Go to http://www.mcraid.com to appeal or purchase an unban");
	}
	@EventHandler
	public void eatSoup(PlayerInteractEvent event) 
	{
	 
	Player player = (Player) event.getPlayer();
	 
	if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) 
	{
	if(player.getItemInHand().getType() == Material.MUSHROOM_SOUP) 
	{
	if(player.getHealth() > 0 && player.getHealth() < 20) 
	{
	if(player.getHealth() + 7 <= 20) 
	{
	player.setHealth(player.getHealth() + 7);
	player.getItemInHand().setType(Material.BOWL);
	} 
	else 
	{
	player.setHealth(20);
	player.getItemInHand().setType(Material.BOWL);
	}
	}
	}
	}
	}
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event)
	{
		Player player = (Player) event.getPlayer();
		Block block = event.getBlock();
		Material material = block.getType();
		if(material == Material.GOLD_ORE)
		{
			Bukkit.getServer().broadcast(ChatColor.DARK_RED + ("[XenonMain]  ") + player.getName() + " has broken a piece of GOLD_ORE", "xenonmain.msg");
		}
		else if(material == Material.DIAMOND_ORE)
		{
			Bukkit.getServer().broadcast(ChatColor.DARK_RED + ("[XenonMain]  ") + player.getName() + " has broken a piece of DIAMOND_ORE", "xenonmain.msg");
		}
	}
}