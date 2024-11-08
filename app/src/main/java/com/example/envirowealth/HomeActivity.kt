package com.example.test

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.scanQrButton).setOnClickListener {
            startActivity(Intent(this, ScanQRActivity::class.java))
        }

        findViewById<Button>(R.id.logoutButton).setOnClickListener {
            finish()
        }

        // Handle Profile and Home as needed.
    }
}
