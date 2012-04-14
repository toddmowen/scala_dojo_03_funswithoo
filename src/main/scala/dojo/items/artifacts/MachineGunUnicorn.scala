package dojo.items.artifacts

import dojo.items.TimedItem


class MachineGunUnicorn extends ArtifactItem with TimedItem {
  val id = 2
  val delay = 60
  def action = "Bam-Bam"
}
