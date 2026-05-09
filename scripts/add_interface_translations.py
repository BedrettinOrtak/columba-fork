"""Add Network Interface translations to all locale strings.xml files."""
from pathlib import Path

REPO = Path(__file__).resolve().parent.parent
RES = REPO / "app" / "src" / "main" / "res"

TRANSLATIONS = {
    "values": {
        "if_title": "Network Interfaces",
        "if_apply_changes": "Apply Changes",
        "if_add_interface": "Add Interface",
        "if_type_interface_desc": "%1$s interface",
        "if_ble_perm_required": "BLE permission required",
        "action_grant": "Grant",
        "action_back": "Back",
        "action_ok": "OK",
        "action_view_details": "View details",
        "if_peer_count_one": "%1$d peer",
        "if_peer_count_other": "%1$d peers",
        "if_delete_title": "Delete Interface?",
        "if_delete_text": "Are you sure you want to delete \\\"%1$s\\\"? This action cannot be undone.",
        "if_applying_changes": "Applying Changes",
        "if_apply_failed_title": "Failed to Apply Changes",
        "if_apply_failed_text": "An error occurred while applying configuration changes:",
        "if_select_type": "Select Interface Type",
        "if_type_auto": "Auto Discovery",
        "if_type_tcp_client": "TCP Client",
        "if_type_ble": "Bluetooth LE",
        "if_type_rnode": "RNode LoRa",
        "if_type_tcp_server": "TCP Server",
        "if_advanced": "Advanced",
        "if_issue_title": "Interface Issue",
        "if_discovery_title": "Interface Discovery",
        "if_discovery_count": "%1$d interfaces found via RNS Discovery",
        "if_discovery_empty": "Discovery enabled - no interfaces found yet",
        "if_discovery_hint": "Tap to configure RNS 1.1.x interface discovery",
    },
    "values-tr": {
        "if_title": "Ağ Arayüzleri",
        "if_apply_changes": "Değişiklikleri Uygula",
        "if_add_interface": "Arayüz Ekle",
        "if_type_interface_desc": "%1$s arayüzü",
        "if_ble_perm_required": "BLE izni gerekli",
        "action_grant": "İzin Ver",
        "action_back": "Geri",
        "action_ok": "Tamam",
        "action_view_details": "Detayları gör",
        "if_peer_count_one": "%1$d eş",
        "if_peer_count_other": "%1$d eş",
        "if_delete_title": "Arayüzü Sil?",
        "if_delete_text": "\\\"%1$s\\\" arayüzünü silmek istediğinizden emin misiniz? Bu işlem geri alınamaz.",
        "if_applying_changes": "Değişiklikler Uygulanıyor",
        "if_apply_failed_title": "Değişiklikler Uygulanamadı",
        "if_apply_failed_text": "Yapılandırma değişiklikleri uygulanırken bir hata oluştu:",
        "if_select_type": "Arayüz Türü Seçin",
        "if_type_auto": "Otomatik Keşif",
        "if_type_tcp_client": "TCP İstemci",
        "if_type_ble": "Bluetooth LE",
        "if_type_rnode": "RNode LoRa",
        "if_type_tcp_server": "TCP Sunucu",
        "if_advanced": "Gelişmiş",
        "if_issue_title": "Arayüz Sorunu",
        "if_discovery_title": "Arayüz Keşfi",
        "if_discovery_count": "RNS Keşfi ile %1$d arayüz bulundu",
        "if_discovery_empty": "Keşif etkin - henüz arayüz bulunamadı",
        "if_discovery_hint": "RNS 1.1.x arayüz keşfini yapılandırmak için dokunun",
    },
    "values-fa": {
        "if_title": "رابط‌های شبکه",
        "if_apply_changes": "اعمال تغییرات",
        "if_add_interface": "افزودن رابط",
        "if_type_interface_desc": "رابط %1$s",
        "if_ble_perm_required": "اجازه BLE لازم است",
        "action_grant": "اعطا",
        "action_back": "بازگشت",
        "action_ok": "باشه",
        "action_view_details": "مشاهده جزئیات",
        "if_peer_count_one": "%1$d همتا",
        "if_peer_count_other": "%1$d همتا",
        "if_delete_title": "حذف رابط؟",
        "if_delete_text": "آیا مطمئنید که می‌خواهید \\\"%1$s\\\" را حذف کنید؟ این عمل قابل بازگشت نیست.",
        "if_applying_changes": "در حال اعمال تغییرات",
        "if_apply_failed_title": "اعمال تغییرات ناموفق بود",
        "if_apply_failed_text": "هنگام اعمال تغییرات پیکربندی خطایی رخ داد:",
        "if_select_type": "انتخاب نوع رابط",
        "if_type_auto": "کشف خودکار",
        "if_type_tcp_client": "کلاینت TCP",
        "if_type_ble": "بلوتوث LE",
        "if_type_rnode": "RNode LoRa",
        "if_type_tcp_server": "سرور TCP",
        "if_advanced": "پیشرفته",
        "if_issue_title": "مشکل رابط",
        "if_discovery_title": "کشف رابط",
        "if_discovery_count": "%1$d رابط از طریق کشف RNS یافت شد",
        "if_discovery_empty": "کشف فعال است - هنوز رابطی یافت نشده",
        "if_discovery_hint": "برای پیکربندی کشف رابط RNS 1.1.x ضربه بزنید",
    },
    "values-ku": {
        "if_title": "Rûyên Torê",
        "if_apply_changes": "Guhertinan Bisepîne",
        "if_add_interface": "Rûyê Zêde Bike",
        "if_type_interface_desc": "Rûyê %1$s",
        "if_ble_perm_required": "Destûra BLE pêwîst e",
        "action_grant": "Bide",
        "action_back": "Vegere",
        "action_ok": "Baş e",
        "action_view_details": "Hûrgilî Bibîne",
        "if_peer_count_one": "%1$d heval",
        "if_peer_count_other": "%1$d heval",
        "if_delete_title": "Rûyê Jêbibe?",
        "if_delete_text": "Tu bawer î ku tu dixwazî \\\"%1$s\\\" jêbibî? Ev kar nayê vegerandin.",
        "if_applying_changes": "Guhertin Tê Sepandin",
        "if_apply_failed_title": "Sepandina Guhertinan Têk Çû",
        "if_apply_failed_text": "Çewtiyek di sepandina veavakirinê de derket:",
        "if_select_type": "Cureyê Rûyê Hilbijêre",
        "if_type_auto": "Vedîtina Otomatîk",
        "if_type_tcp_client": "Mişterî TCP",
        "if_type_ble": "Bluetooth LE",
        "if_type_rnode": "RNode LoRa",
        "if_type_tcp_server": "Server TCP",
        "if_advanced": "Pêşketî",
        "if_issue_title": "Pirsgirêka Rûyê",
        "if_discovery_title": "Vedîtina Rûyê",
        "if_discovery_count": "Bi RNS Discovery %1$d rûyek hat dîtin",
        "if_discovery_empty": "Vedîtin çalak e - hîn rûyek nehat dîtin",
        "if_discovery_hint": "Ji bo veavakirina vedîtina RNS 1.1.x bitikîne",
    },
}


def main() -> None:
    for locale_dir, kv in TRANSLATIONS.items():
        path = RES / locale_dir / "strings.xml"
        content = path.read_text(encoding="utf-8")
        new_lines = []
        added = 0
        for key, value in kv.items():
            if f'name="{key}"' in content:
                continue
            new_lines.append(f'    <string name="{key}">{value}</string>')
            added += 1
        if not new_lines:
            print(f"{locale_dir}: no new keys")
            continue
        block = "\n    <!-- Network Interfaces (auto-added) -->\n" + "\n".join(new_lines) + "\n"
        content = content.replace("</resources>", block + "</resources>")
        path.write_text(content, encoding="utf-8")
        print(f"{locale_dir}: added {added} keys")


if __name__ == "__main__":
    main()

