import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.await
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BookRepository {
    private val bookService: BookService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/volumes/<volume_id>")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        bookService = retrofit.create(BookService::class.java)
    }

    suspend fun searchBooks(query: String): List<Book> {
        return withContext(Dispatchers.IO) {
            val response = bookService.searchBooks(query).await()
            response.items
        }
    }
}