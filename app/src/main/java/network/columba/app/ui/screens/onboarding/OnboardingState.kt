package network.columba.app.ui.screens.onboarding

import androidx.compose.runtime.Immutable
import androidx.annotation.StringRes
import network.columba.app.R

/**
 * State for the paged onboarding flow.
 */
@Immutable
data class OnboardingState(
    val currentPage: Int = 0,
    val displayName: String = "",
    val selectedInterfaces: Set<OnboardingInterfaceType> = setOf(OnboardingInterfaceType.AUTO),
    val notificationsEnabled: Boolean = false,
    val notificationsGranted: Boolean = false,
    val batteryOptimizationExempt: Boolean = false,
    val isSaving: Boolean = false,
    val isLoading: Boolean = true,
    val hasCompletedOnboarding: Boolean = false,
    val error: String? = null,
    val blePermissionsGranted: Boolean = false,
    val blePermissionsDenied: Boolean = false,
)

/**
 * Interface types that can be enabled during onboarding.
 * Simplified version of the full InterfaceConfig for user selection.
 */
enum class OnboardingInterfaceType(
    @StringRes val displayNameRes: Int,
    @StringRes val descriptionRes: Int,
    @StringRes val secondaryDescriptionRes: Int? = null,
) {
    AUTO(
        displayNameRes = R.string.onboarding_connectivity_interface_auto,
        descriptionRes = R.string.onboarding_connectivity_interface_auto_desc,
        secondaryDescriptionRes = R.string.onboarding_connectivity_interface_auto_secondary,
    ),
    BLE(
        displayNameRes = R.string.onboarding_connectivity_interface_ble,
        descriptionRes = R.string.onboarding_connectivity_interface_ble_desc,
        secondaryDescriptionRes = R.string.onboarding_connectivity_interface_ble_secondary,
    ),
    TCP(
        displayNameRes = R.string.onboarding_connectivity_interface_tcp,
        descriptionRes = R.string.onboarding_connectivity_interface_tcp_desc,
        secondaryDescriptionRes = R.string.onboarding_connectivity_interface_tcp_secondary,
    ),
    RNODE(
        displayNameRes = R.string.onboarding_connectivity_interface_rnode,
        descriptionRes = R.string.onboarding_connectivity_interface_rnode_desc,
        secondaryDescriptionRes = R.string.onboarding_connectivity_interface_rnode_secondary,
    ),

    ;

    // Backward compatibility for tests and non-UI call sites that still assert English labels.
    val displayName: String
        get() =
            when (this) {
                AUTO -> "Local WiFi"
                BLE -> "Bluetooth LE"
                TCP -> "Internet (TCP)"
                RNODE -> "LoRa Radio"
            }

    val description: String
        get() =
            when (this) {
                AUTO -> "Discover peers on your local network"
                BLE -> "Connect directly to nearby devices"
                TCP -> "Connect to the global Reticulum network"
                RNODE -> "Long-range mesh via RNode hardware"
            }

    val secondaryDescription: String?
        get() =
            when (this) {
                AUTO -> "No internet required"
                BLE -> "Requires Bluetooth permissions"
                TCP -> "Requires internet connection"
                RNODE -> "Requires external hardware - configure in Settings"
            }
}

/**
 * Total number of onboarding pages.
 */
const val ONBOARDING_PAGE_COUNT = 5
