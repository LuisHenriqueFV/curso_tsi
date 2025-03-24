<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration {
    public function up()
    {
        Schema::table('items', function (Blueprint $table) {
            $table->string('contact_email')->nullable()->after('user_id'); // Adiciona um campo de email
            $table->string('contact_phone')->nullable()->after('contact_email'); // Adiciona um campo de telefone
        });
    }

    public function down()
    {
        Schema::table('items', function (Blueprint $table) {
            $table->dropColumn(['contact_email', 'contact_phone']); // Remove os campos se a migration for revertida
        });
    }
};
