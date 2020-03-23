class SqlExtractor {
    val stringBuilderExtract = { s:String ->
        val regex = """.*?\.append\s*\(\s*"(.*)"\s*\)\s*;\s*""".toRegex()
        val output = regex.findAll(s).map {
            it.groups[0]?.value.toString()
        }
        output.toString()
    }

    fun extractSql(sql: String, step: (String) -> String): String {
        return step(sql)
    }


}



