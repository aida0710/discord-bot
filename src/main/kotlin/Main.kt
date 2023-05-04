import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.requests.GatewayIntent

const val TOKEN = ""
const val GUILD_ID = "550022116158865468"

fun main() {
    Startup().main()
}

class Startup : ListenerAdapter() {

    private lateinit var jda: JDA
    private lateinit var guild: Guild

    fun main() {
        jda = JDABuilder.createLight(TOKEN, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
            .addEventListeners(this)
            .setStatus(OnlineStatus.ONLINE)
            .setRawEventsEnabled(true)
            .setActivity(Activity.playing("管理者 -> https://lazyperson0710.tech"))
            .build()
        guild = jda.getGuildById(GUILD_ID)!!
    }
}
