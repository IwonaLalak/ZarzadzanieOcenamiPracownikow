package sample.database;

import java.sql.*;

public class Database {
    public void init() {

        this.update("ALTER TABLE `logs`\n" +
                "        DROP FOREIGN KEY `logs-user-fk`,\n" +
                "        DROP FOREIGN KEY `logs-vote-fk`");
        this.update("ALTER TABLE `questions`\n" +
                "        DROP FOREIGN KEY `questionform - quesiton - fk`\n");
        this.update("ALTER TABLE `raports`\n" +
                "        DROP FOREIGN KEY `raports - votes - fk`");
        this.update("ALTER TABLE `users`\n" +
                "        DROP FOREIGN KEY `user - sector - fk`");
        this.update("ALTER TABLE `user_fill_vote`\n" +
                "        DROP FOREIGN KEY `user - fill`,\n" +
                "        DROP FOREIGN KEY `user - vote`");
        this.update("ALTER TABLE `votes`\n" +
                "        DROP FOREIGN KEY `vote - questionform - fk`,\n" +
                "        DROP FOREIGN KEY `vote - section - fk`");

        this.update("DROP TABLE IF EXISTS questions");
        this.update("DROP TABLE IF EXISTS sectors");
        this.update("DROP TABLE IF EXISTS questionforms");
        this.update("DROP TABLE IF EXISTS raports");
        this.update("DROP TABLE IF EXISTS users");
        this.update("DROP TABLE IF EXISTS user_fill_vote");
        this.update("DROP TABLE IF EXISTS votes");
        this.update("DROP TABLE IF EXISTS logs");

        this.update("\n" +
                "CREATE TABLE `questions` (\n" +
                "  `id` int(11) NOT NULL,\n" +
                "  `content` text COLLATE utf8_polish_ci NOT NULL,\n" +
                "  `questionform_id` int(11) NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;");
        this.update("CREATE TABLE `sectors` (\n" +
                "        `id` int(11) NOT NULL,\n" +
                "  `name` text COLLATE utf8_polish_ci NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;");
        this.update("CREATE TABLE `questionforms` (\n" +
                "  `id` int(11) NOT NULL,\n" +
                "  `name` text COLLATE utf8_polish_ci NOT NULL,\n" +
                "  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                "  `number_of_questions` int(11) NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;");
        this.update("CREATE TABLE `raports` (\n" +
                "  `id` int(11) NOT NULL,\n" +
                "  `raport_name` text COLLATE utf8_polish_ci NOT NULL,\n" +
                "  `vote_id` int(11) NOT NULL,\n" +
                "  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                "  `raport_content` text COLLATE utf8_polish_ci NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci");
        this.update("CREATE TABLE `users` (\n" +
                "  `id` int(11) NOT NULL,\n" +
                "  `login` text COLLATE utf8_polish_ci NOT NULL,\n" +
                "  `password` text COLLATE utf8_polish_ci NOT NULL,\n" +
                "  `firstname` text COLLATE utf8_polish_ci NOT NULL,\n" +
                "  `lastname` text COLLATE utf8_polish_ci NOT NULL,\n" +
                "  `type` text COLLATE utf8_polish_ci NOT NULL,\n" +
                "  `sector_id` int(11) NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci");
        this.update("CREATE TABLE `user_fill_vote` (\n" +
                "  `id` int(11) NOT NULL,\n" +
                "  `user_id` int(11) NOT NULL,\n" +
                "  `vote_id` int(11) NOT NULL,\n" +
                "  `filled` tinyint(1) NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci");
        this.update(" CREATE TABLE `votes` (\n" +
                "  `id` int(11) NOT NULL,\n" +
                "  `vote_name` text COLLATE utf8_polish_ci NOT NULL,\n" +
                "  `date_from` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                "  `date_to` datetime NOT NULL,\n" +
                "  `is_current` tinyint(1) NOT NULL,\n" +
                "  `who` text COLLATE utf8_polish_ci NOT NULL,\n" +
                "  `section_id` int(11) NOT NULL,\n" +
                "  `questionform_id` int(11) NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci");
        this.update("CREATE TABLE `logs` (\n" +
                "  `id` int(11) NOT NULL,\n" +
                "  `vote_id` int(11) NOT NULL,\n" +
                "  `user_id` int(11) NOT NULL,\n" +
                "  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                "  `log_content` text COLLATE utf8_polish_ci NOT NULL,\n" +
                "  `log_short` text COLLATE utf8_polish_ci NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;");

        this.update("ALTER TABLE `logs`\n" +
                "        ADD PRIMARY KEY (`id`),\n" +
                "                ADD KEY `logs-user-fk` (`user_id`),\n" +
                "        ADD KEY `logs-vote-fk` (`vote_id`)");
        this.update(" ALTER TABLE `questionforms`\n" +
                "        ADD PRIMARY KEY (`id`)");
        this.update("ALTER TABLE `questions`\n" +
                "        ADD PRIMARY KEY (`id`),\n" +
                "                ADD KEY `questionform-quesiton-fk` (`questionform_id`)");
        this.update("ALTER TABLE `raports`\n" +
                "        ADD PRIMARY KEY (`id`),\n" +
                "                ADD KEY `raports-votes-fk` (`vote_id`)");
        this.update("ALTER TABLE `sectors`\n" +
                "        ADD PRIMARY KEY (`id`)");
        this.update("ALTER TABLE `users`\n" +
                "        ADD PRIMARY KEY (`id`),\n" +
                "                ADD KEY `user-sector-fk` (`sector_id`)");
        this.update("ALTER TABLE `user_fill_vote`\n" +
                "        ADD PRIMARY KEY (`id`),\n" +
                "                ADD KEY `user-fill` (`user_id`),\n" +
                "        ADD KEY `user-vote` (`vote_id`)");
        this.update("ALTER TABLE `votes`\n" +
                "        ADD PRIMARY KEY (`id`),\n" +
                "                ADD KEY `vote-questionform-fk` (`questionform_id`),\n" +
                "        ADD KEY `vote-section-fk` (`section_id`)");

        this.update("ALTER TABLE `logs`\n" +
                "        MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13");
        this.update("ALTER TABLE `questionforms`\n" +
                "        MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4");
        this.update(" ALTER TABLE `questions`\n" +
                "        MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6");
        this.update("ALTER TABLE `raports`\n" +
                "        MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2");
        this.update("ALTER TABLE `sectors`\n" +
                "        MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4");
        this.update("ALTER TABLE `users`\n" +
                "        MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6");
        this.update("ALTER TABLE `user_fill_vote`\n" +
                "        MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8");
        this.update("ALTER TABLE `votes`\n" +
                "        MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16");
        this.update("ALTER TABLE `logs`\n" +
                "        ADD CONSTRAINT `logs-user-fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),\n" +
                "        ADD CONSTRAINT `logs-vote-fk` FOREIGN KEY (`vote_id`) REFERENCES `votes` (`id`)");
        this.update("ALTER TABLE `questions`\n" +
                "        ADD CONSTRAINT `questionform - quesiton - fk`FOREIGN KEY (`questionform_id`)REFERENCES `questionforms`(`id`)\n" +
                "        ON DELETE CASCADE");
        this.update("ALTER TABLE `raports`\n" +
                "        ADD CONSTRAINT `raports - votes - fk`FOREIGN KEY (`vote_id`)REFERENCES `votes`(`id`)");
        this.update("ALTER TABLE `users`\n" +
                "        ADD CONSTRAINT `user - sector - fk`FOREIGN KEY (`sector_id`)REFERENCES `sectors`(`id`)");
        this.update("ALTER TABLE `user_fill_vote`\n" +
                "        ADD CONSTRAINT `user - fill`FOREIGN KEY (`user_id`)REFERENCES `users`(`id`),\n" +
                "        ADD CONSTRAINT `user - vote`FOREIGN KEY (`vote_id`)REFERENCES `votes`(`id`)");
        this.update("ALTER TABLE `votes`\n" +
                "        ADD CONSTRAINT `vote - questionform - fk`FOREIGN KEY (`questionform_id`)REFERENCES `questionforms`(`id`),\n" +
                "        ADD CONSTRAINT `vote - section - fk`FOREIGN KEY (`section_id`)REFERENCES `sectors`(`id`)");
    }

    public void seed() {
        this.update("INSERT INTO `questionforms` (`id`, `name`, `creation_date`, `number_of_questions`) VALUES\n" +
                "(2, 'praca&lowbar;grupowa', '2017-03-25 18:20:42', 2),\n" +
                "(3, 'komfort&lowbar;pracy', '2017-03-25 18:36:37', 3);");
        this.update("INSERT INTO `sectors` (`id`, `name`) VALUES\n" +
                "(1, 'HR'),\n" +
                "(2, 'Produkcja'),\n" +
                "(3, 'Marketing');");
        this.update("\n" +
                "INSERT INTO `users` (`id`, `login`, `password`, `firstname`, `lastname`, `type`, `sector_id`) VALUES\n" +
                "(1, 'ilalak', 'xxx', 'iwona', 'lalak', 'kierownik', 1),\n" +
                "(3, 'anowak', 'xxx', 'adam', 'nowak', 'pracownik', 2),\n" +
                "(4, 'jkowalski', 'xxx', 'jan', 'kowalski', 'kierownik', 2),\n" +
                "(5, 'madamczyk', 'xxx', 'michal', 'adamczyk', 'pracownik', 2);");
        this.update("INSERT INTO `votes` (`id`, `vote_name`, `date_from`, `date_to`, `is_current`, `who`, `section_id`, `questionform_id`) VALUES\n" +
                "(1, 'glosowanie x', '2017-03-25 20:20:38', '2017-04-22 00:00:00', 0, 'pracownik', 2, 3),\n" +
                "(12, 'glosowanietestowe5', '2017-03-25 21:29:42', '2017-04-22 00:00:00', 0, 'pracownik', 2, 2),\n" +
                "(13, 'ocena', '2017-03-25 21:35:26', '2017-04-20 00:00:00', 1, 'pracownik', 2, 3),\n" +
                "(14, 'ocena', '2017-03-25 21:35:26', '2017-04-20 00:00:00', 1, 'kierownik', 2, 3),\n" +
                "(15, 'dssdds', '2017-03-25 23:52:57', '2017-04-22 00:00:00', 0, 'pracownik', 3, 3);");
        this.update("\n" +
                "INSERT INTO `user_fill_vote` (`id`, `user_id`, `vote_id`, `filled`) VALUES\n" +
                "(3, 3, 12, 1),\n" +
                "(4, 5, 12, 1),\n" +
                "(5, 3, 13, 0),\n" +
                "(6, 5, 13, 0),\n" +
                "(7, 4, 14, 0);");
        this.update("\n" +
                "INSERT INTO `questions` (`id`, `content`, `questionform_id`) VALUES\n" +
                "(1, 'Ocen zaangazowanie', 2),\n" +
                "(2, 'Ocen wiedze', 2),\n" +
                "(3, 'Ocen poziom atmosfery', 3),\n" +
                "(4, 'Ocen poziom checi do pomocy', 3),\n" +
                "(5, 'Ocen poziom wiedzy', 3);");
        this.update("INSERT INTO `logs` (`id`, `vote_id`, `user_id`, `date`, `log_content`, `log_short`) VALUES\n" +
                "(1, 12, 3, '2017-03-25 23:41:36', 'Uzytkownik adam nowak ocenil adam nowak na ocene 3 w pytaniu Ocen zaangazowanie', 'adam nowak;3;Ocen zaangazowanie'),\n" +
                "(2, 12, 3, '2017-03-25 23:41:36', 'Uzytkownik adam nowak ocenil adam nowak na ocene 2 w pytaniu Ocen wiedze', 'adam nowak;2;Ocen wiedze'),\n" +
                "(3, 12, 3, '2017-03-25 23:41:36', 'Uzytkownik adam nowak ocenil jan kowalski na ocene 3 w pytaniu Ocen zaangazowanie', 'jan kowalski;3;Ocen zaangazowanie'),\n" +
                "(4, 12, 3, '2017-03-25 23:41:36', 'Uzytkownik adam nowak ocenil jan kowalski na ocene 4 w pytaniu Ocen wiedze', 'jan kowalski;4;Ocen wiedze'),\n" +
                "(5, 12, 3, '2017-03-25 23:41:36', 'Uzytkownik adam nowak ocenil michal adamczyk na ocene 3 w pytaniu Ocen zaangazowanie', 'michal adamczyk;3;Ocen zaangazowanie'),\n" +
                "(6, 12, 3, '2017-03-25 23:41:36', 'Uzytkownik adam nowak ocenil michal adamczyk na ocene 3 w pytaniu Ocen wiedze', 'michal adamczyk;3;Ocen wiedze'),\n" +
                "(7, 12, 5, '2017-03-26 19:51:29', 'Uzytkownik michal adamczyk ocenil adam nowak na ocene 3 w pytaniu Ocen zaangazowanie', 'adam nowak;3;Ocen zaangazowanie'),\n" +
                "(8, 12, 5, '2017-03-26 19:51:29', 'Uzytkownik michal adamczyk ocenil adam nowak na ocene 2 w pytaniu Ocen wiedze', 'adam nowak;2;Ocen wiedze'),\n" +
                "(9, 12, 5, '2017-03-26 19:51:29', 'Uzytkownik michal adamczyk ocenil jan kowalski na ocene 4 w pytaniu Ocen zaangazowanie', 'jan kowalski;4;Ocen zaangazowanie'),\n" +
                "(10, 12, 5, '2017-03-26 19:51:29', 'Uzytkownik michal adamczyk ocenil jan kowalski na ocene 2 w pytaniu Ocen wiedze', 'jan kowalski;2;Ocen wiedze'),\n" +
                "(11, 12, 5, '2017-03-26 19:51:29', 'Uzytkownik michal adamczyk ocenil michal adamczyk na ocene 4 w pytaniu Ocen zaangazowanie', 'michal adamczyk;4;Ocen zaangazowanie'),\n" +
                "(12, 12, 5, '2017-03-26 19:51:29', 'Uzytkownik michal adamczyk ocenil michal adamczyk na ocene 3 w pytaniu Ocen wiedze', 'michal adamczyk;3;Ocen wiedze');");
        this.update("INSERT INTO `raports` (`id`, `raport_name`, `vote_id`, `date`, `raport_content`) VALUES\n" +
                "(1, 'raport z glosowanietestowe5', 12, '2017-03-26 19:51:51', " +
                "'adam nowak;3;Ocen zaangazowanie<br/>adam nowak;2;Ocen wiedze<br/>jan kowalski;3;Ocen zaangazowanie<br/>" +
                "jan kowalski;4;Ocen wiedze<br/>michal adamczyk;3;Ocen zaangazowanie<br/>" +
                "michal adamczyk;3;Ocen wiedze<br/>adam nowak;3;Ocen zaangazowanie<br/>" +
                "adam nowak;2;Ocen wiedze<br/>jan kowalski;4;Ocen zaangazowanie<br/>" +
                "jan kowalski;2;Ocen wiedze<br/>michal adamczyk;4;Ocen zaangazowanie<br/>" +
                "michal adamczyk;3;Ocen wiedze<br/>');");
    }


    public static Statement prepareStatement() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;

        DbDetailsProvider dbDetailsProvider = new DbDetailsProvider();
        String user = dbDetailsProvider.getUser();
        String pass = dbDetailsProvider.getPass();
        String host = dbDetailsProvider.getHost();

        Class.forName("com.mysql.jdbc.Driver");

        conn = DriverManager.getConnection(host, user, pass);
        stmt = (Statement) conn.createStatement();

        return stmt;
    }

    public static ResultSet execute(String sql) {
        System.out.println(sql);
        ResultSet result = null;

        try {
            Statement stmt = Database.prepareStatement();

            result = stmt.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public static void update(String sql) {
        System.out.println(sql);
        try {
            Statement stmt = Database.prepareStatement();

            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
