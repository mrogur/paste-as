import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SqlExtractorKtTest {

    @Test
    fun extractSql() {
        val ex = SqlExtractor()
        val query = """
            sb.append(" SELECT * FROM ");
            sb.append(" TABLE TL ");
            sb.append("WHERE TL.X = ? ");
        """.trimIndent()
        ex.extractSql(query, ex.stringBuilderExtract)
    }
}
